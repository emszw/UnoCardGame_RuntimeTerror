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
    
    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }
    
    public void fillHand(GroupOfCards deck) {
        for (int i = 0; i < 7; i++) {
            try {
                hand.add(deck.drawCard());
            } catch (UnoCardException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void displayHand() {
        System.out.println("Hands of player: " + super.getName());
        for (UnoCard unoCard : hand) 
            System.out.println(unoCard.toString());     
    }
    
    
    @Override
    public void play(CardGame.GroupOfCards deck) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
