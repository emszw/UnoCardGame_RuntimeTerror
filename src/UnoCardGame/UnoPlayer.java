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
    private static Scanner scan = new Scanner(System.in);
    
    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        size = 0;
    }

    public int getSize() {
        return size;
    }
    
    
    
    /**
     * Player method utilised to draw cards from a GroupOfCards
     * @param deck : The GroupOfCards from which the UnoCards will be drawn from
     * @param ammount : The ammount of cards to be drawn
     */
    public void drawToHand(GroupOfCards deck, int ammount) {
        for (int i = 0; i < ammount; i++) {
            try {
                hand.add(deck.drawCard());
                size++;
            } catch (UnoCardException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Method used for debugging reasons only
     */
    public void displayHand() {
        System.out.println("Hands of player: " + super.getName());
        for (UnoCard unoCard : hand) 
            System.out.println(unoCard.toString());     
    }
    
    
    private ArrayList<Integer> discardOptions(UnoCard topOfTable) {
        ArrayList<Integer> availableOptions = new ArrayList<>();
        for (UnoCard unoCard : hand) {
            if(unoCard.getColor() == topOfTable.getColor() ||
                    unoCard.getNumber() == topOfTable.getNumber() ||
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
        do {
            System.out.println("Select one of the available options to discard");
            choice = scan.nextInt();
            scan.nextLine();
        } while(!availableOptions.contains(choice));
        return choice;
    }
    
    public void discardFromHand(ArrayList<UnoCard> table, GroupOfCards deck) throws UnoCardException {
        System.out.println("Card on top of the table: " +
                table.get(table.size()-1));
        if(!discardOptions(table.get(table.size()-1)).isEmpty()) {
            table.add(hand.remove(discardChoice(discardOptions(table.get(table.size()-1)))));
            UnoCard topOfTable = table.get(table.size()-1);
            if(topOfTable.isWild()) {
                int choice = -1;
                System.out.println("Choose the color for the WildCard: ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(i + ". " + CardColor.fromInt(i));
                }
                do {
                    choice = Integer.parseInt(scan.nextLine());
                } while (choice < 0 || choice > 3);
                topOfTable.setColor(CardColor.fromInt(choice));
                topOfTable.setActionTaken(true);
            }
            System.out.println("New card on top of the table: " +
            table.get(table.size()-1) );
            size--;
        } else {
            System.out.println("No available cards in hand to discard, drawing "
                    + "one card from the deck");
            drawToHand(deck, 1);
        }
        if(size == 0) {
            scan.close();
            throw new UnoCardException("Player has no more cards in hand!", CardException.EMPTY_HAND);
        }
        if(size == 1) {
            throw new UnoCardException("UNO! Player " + super.getName() + 
                    " has only one card in hand!", CardException.UNO);
        }
    }
    
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
