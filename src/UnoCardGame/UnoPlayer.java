/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Player;
import java.util.ArrayList;

/**
 *
 * @author Kimio Nishino
 */
public class UnoPlayer extends Player {
    
    private ArrayList<UnoCard> hand;
    private static int size;
    
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
    
    
    public ArrayList<Integer> discardOptions(UnoCard topOfTable) {
        ArrayList<Integer> availableOptions = new ArrayList<>();
        for (UnoCard unoCard : hand) {
            if(unoCard.getColor() == topOfTable.getColor() ||
                    unoCard.getNumber() == topOfTable.getNumber())
                availableOptions.add(hand.indexOf(unoCard));    
        }
        return availableOptions;
    }
    
    public UnoCard discard(){
        return null;
    }
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
