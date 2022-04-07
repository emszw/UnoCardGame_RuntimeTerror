/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Player;
import java.util.ArrayList;
import java.util.Scanner;
import UnoCardGame.CardProperties.*;
import UnoCardGame.UnoCardException.*;
/**
 *
 * @author Kimio Nishino
 */
public class UnoPlayer extends Player {
    
    private ArrayList<UnoCard> hand;
    private int size;
    private  boolean bot;
    private static Scanner scan = new Scanner(System.in);
    
    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        bot = true;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }
    
    
    
    
    /**
     * Player method utilised to draw cards from a GroupOfCards
     * @param deck : The GroupOfCards from which the UnoCards will be drawn from
     * @param ammount : The ammount of cards to be drawn
     * @throws UnoCardGame.UnoCardException
     */
    public void drawToHand(GroupOfCards deck, int ammount) throws UnoCardException {
        if(deck.getCards().size() - ammount < 1)
            throw new UnoCardException("Deck will be empty before pulling the"
                    + " right ammount!", CardException.EMPTY_DECK);
        for (int i = 0; i < ammount; i++) {
            hand.add(deck.drawCard());
            size++;
        }
    }
    
    /**
     * Method used for debugging reasons only
     */
    public void displayHand() {
        System.out.println("Cards in the hands of player: " + super.getName());
        for (UnoCard unoCard : hand) 
            System.out.println(unoCard.toString());     
    }
    
    
    private ArrayList<Integer> discardOptions(UnoCard topOfTable) {
        ArrayList<Integer> availableOptions = new ArrayList<>();
        for (UnoCard unoCard : hand) {
            if(unoCard.getColor() == topOfTable.getColor() ||
                    (unoCard.getNumber() == topOfTable.getNumber() &&
                    unoCard.getNumber() != CardNumber.NO_NUMBER) ||
                    unoCard.getRank() == CardRank.WILD ||
                    unoCard.getRank() == CardRank.WILD_DRAW4)
                availableOptions.add(hand.indexOf(unoCard));    
        }
        return availableOptions;
    }
    
    private int discardChoice(ArrayList<Integer> availableOptions){
        int choice;
        System.out.println("Available options to discard: ");
        for (Integer availableOption : availableOptions) {
            System.out.println(availableOption + ": " + 
                    hand.get(availableOption).toString());
        }
        if(!isBot()) {
            do {
                System.out.println("Select one of the available options to discard");
                choice = scan.nextInt();
                scan.nextLine();
            } while(!availableOptions.contains(choice));
        } else {
            choice = availableOptions.get((int) (availableOptions.size() * Math.random()));
        }
        return choice;
    }
    
    public void discardFromHand(ArrayList<UnoCard> table, GroupOfCards deck) throws UnoCardException {
        if(!discardOptions(table.get(table.size()-1)).isEmpty()) {
            table.add(hand.remove(discardChoice(discardOptions(table.get(table.size()-1)))));
            UnoCard topOfTable = table.get(table.size()-1);
            if(topOfTable.isWild()) {
                int choice = -1;
                System.out.println("Choose the color for the WildCard: ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(i + ". " + CardColor.fromInt(i));
                }
                if(!isBot()) {
                    do {
                        choice = Integer.parseInt(scan.nextLine());
                    } while (choice < 0 || choice > 3);
                } else {
                    choice = (int) (Math.random() * 4);
                }
                topOfTable.setColor(CardColor.fromInt(choice));
                topOfTable.setActionTaken(false);
            }
            System.out.println("New card on top of the table: " +
            table.get(table.size()-1) );
            size--;
        } else {
            System.out.println("No available cards in hand to discard, player " +
                    getName() + " drawing one card from the deck");
            drawToHand(deck, 1);
        }
        if(size == 0) {
            scan.close();
            throw new UnoCardException("Player has no more cards in hand!", CardException.EMPTY_HAND);
        }
    }
    
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
