/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Game;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kimio Nishino
 */
public class UnoCardGame extends Game{
    
    private static ArrayList<UnoPlayer> players;

    
    
    public static void startGame(GroupOfCards cards, ArrayList<UnoPlayer> players) {
        System.out.println("Initializing players...");  
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<4; i++) {
            System.out.println("Name for player " + i + ": ");
            players.add(new UnoPlayer(scan.nextLine()));
            players.get(i).fillHand(cards);
        }
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Welcome to Uno Card Game");
        players = new ArrayList<>(4);
        GroupOfCards deck = new GroupOfCards();
        deck.fillDeck();
        deck.shuffle();
        startGame(deck, players);
        for (UnoPlayer player : players) {
            player.displayHand();
        }
        System.out.println(deck.getSize() + " cards remaining in the deck");
        System.out.println("Full deck remaining: ");
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
