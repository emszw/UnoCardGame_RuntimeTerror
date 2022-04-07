/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Game;
import java.util.ArrayList;
import UnoCardGame.CardProperties.*;
import UnoCardGame.UnoCardException.*;

/**
 *
 * @author Kimio Nishino
 */
public class UnoCardGame extends Game{
    
    private static GroupOfCards deck;
    private static ArrayList<UnoPlayer> players;
    private static ArrayList<UnoCard> table;
    private static boolean clockwise = true;
    private static boolean checkWinner = false;
    private static int rounds = 0;
    private static int playerIndex = 0;
    

    
    
    public void initializeGame(String[] args) {
        System.out.println("Initializing game...");
        deck.fillDeck();
        deck.shuffle();
        System.out.println("Initializing players...");  
//        Scanner scan = new Scanner(System.in);
        for (int i=0; i<4; i++) {
            players.add(new UnoPlayer(args[i]));
            players.get(i).drawToHand(deck, 7);
            System.out.println("Name for player " + i + ": " + players.get(i).getName());

        }      
        try{
            table.add(deck.drawCard());
            while(table.get(0).getRank() == CardRank.WILD ||
                    table.get(0).getRank() == CardRank.WILD_DRAW4) {
                System.out.println("Card pulled to the table was a WILD CARD");
                deck.addCardToDeck(table.remove(0));
                table.add(deck.drawCard());
                System.out.println("New Card pulled to table: " + table.get(0).toString());
            }
        } catch(UnoCardException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause of exception: " + e.getTException());
        }
    }
    
    
    public static void displayRound(){
        System.out.println("Current ammount of cards on Deck: " + deck.getSize());
        System.out.println("============================");
        System.out.println("Card on top of the table: " + table.get(table.size()-1).toString());
        for (UnoPlayer player : players) {
            System.out.println("Number of cards on the hands of player " + player.getName() + ": " + player.getSize());
        }
        System.out.println("============================");
        System.out.println("Current player order:");
        for (UnoPlayer player : players) {
            if(clockwise)
                System.out.print(" > ");
            else
                System.out.print(" < ");
            if(players.indexOf(player) == playerIndex) {
                System.out.print("[" + player.getName() + "]");
            } else
                System.out.print(player.getName());
        }
        System.out.println();
    }
    
    @Override
    public void play() {
        System.out.println("Game starting!!");
        while(!checkWinner) {
            displayRound();
            try {
                players.get(playerIndex).discardFromHand(table, deck);
                
            } catch (UnoCardException e) {
                if(e.getTException() == CardException.EMPTY_HAND)
                    checkWinner = true;
            }
            if(clockwise) {
                playerIndex++;
                if(playerIndex >= 4)
                    playerIndex = 0;
            } else {
                playerIndex--;
                if(playerIndex < 0)
                    playerIndex = 3;
            }
        }
        declareWinner();
    }
    
    
    public void checkTableAction() {
        UnoCard topOfTable = table.get(table.size()-1);
        if(topOfTable.getRank() != CardRank.NUMBER && topOfTable.isActionTaken() ) {
            if(topOfTable.getRank() == CardRank.REVERSE) {
                clockwise = !clockwise;
            }
        }
    }
    
    
        
    public UnoCardGame() {
        super("Uno Card Game");
        players = new ArrayList<>(4);
        table = new ArrayList<>();
        deck = new GroupOfCards();
    }

    @Override
    public void declareWinner() {
        System.out.println("Game over, player " + players.get(playerIndex).getName() + "won!");
    }
    
}
