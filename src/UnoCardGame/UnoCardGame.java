/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Game;

/**
 *
 * @author Kimio Nishino
 */
public class UnoCardGame extends Game{
    
    public static void main(String[] args) {
        System.out.println("Hello world");
        GroupOfCards deck = new GroupOfCards();
        deck.fillDeck();
        System.out.println("Size of deck: " + deck.getSize());
        deck.printGroup();
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    public UnoCardGame() {
        super("Uno Card Game");
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
