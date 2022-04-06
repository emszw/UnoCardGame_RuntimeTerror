/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Player;
import java.util.ArrayList;
import java.util.Scanner;
import UnoCardGame.CardProperties.CardRank;
import UnoCardGame.UnoCardException.*;
/**
 *
 * @author Kimio Nishino
 */
public class UnoPlayer extends Player {
    
    private ArrayList<UnoCard> hand;
    private int size;
    
    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        size = 0;
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
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Available options to discard: ");
        for (Integer availableOption : availableOptions) {
            System.out.println(availableOption + ": " + 
                    hand.get(availableOption).toString());
        }
        do {
            System.out.println("Select one of the available options to discard");
            choice = scan.nextInt();
        } while(!availableOptions.contains(choice));
        scan.close();
        return choice;
    }
    
    public void discardFromHand(ArrayList<UnoCard> table) throws UnoCardException {
        System.out.println("Card on top of the table: " +
                table.get(table.size()-1));
        table.add(hand.remove(discardChoice(discardOptions(table.get(table.size()-1)))));
        System.out.println("New card on top of the table: " +
                table.get(table.size()-1) );
        size--;
        if(size == 0)
            throw new UnoCardException("Player has no more cards in hand!", CardException.EMPTY_HAND);
        if(size == 1)
            throw new UnoCardException("UNO! Player " + super.getName() + 
                    " has only one card in hand!", CardException.UNO);
    }
    
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
