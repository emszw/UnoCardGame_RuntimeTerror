/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Game;
import java.util.ArrayList;
import UnoCardGame.CardProperties.*;
import UnoCardGame.UnoCardException.*;
import java.util.Scanner;

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
    private static int winner;
    

    
    
    public void initializeGame(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Initializing game...");
        deck.fillDeck();
        deck.shuffle();
        int botChoice;
        System.out.println("Do you wanna start the game in Bot Mode?");  
        do {     
            System.out.println("1. Yes | 2. No");
            botChoice = scan.nextInt();
            scan.nextLine();
        } while (botChoice != 1 && botChoice != 2);
        boolean botMode = false;
        if(botChoice == 1)
            botMode = true;
        System.out.println("Initializing players...");  

        for (int i=0; i<4; i++) {
            players.add(new UnoPlayer(args[i]));
            if(i==0) {
                players.get(0).setBot(botMode);
            }
            try {
                players.get(i).drawToHand(deck, 7);
            } catch (UnoCardException e) {
                System.out.println("Unexpected exception when initializing players");
                System.out.println(e.getMessage() + "\n" +e.getTException());
            }   
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
        System.out.println("==========ROUND " + rounds +"==============");
        System.out.println("Current ammount of cards on Deck: " + deck.getSize());
        System.out.println("============================");
        for (UnoPlayer player : players) {
            if(player.getSize() == 1) {
                System.out.print("Number of cards on the hands of player " + player.getName() + ": " + player.getSize());
                System.out.println(" [UNO!!!]");
            } else {
                System.out.println("Number of cards on the hands of player " + player.getName() + ": " + player.getSize());
            }
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
        players.get(playerIndex).displayHand();
        System.out.println("=================================");
        System.out.println(">>>>Card on top of the table: " + table.get(table.size()-1).toString() + "<<<<<");

    }
    
    @Override
    public void play() {
        System.out.println("Game starting!!");
        while(!checkWinner) {
            displayRound();
            try {
                players.get(playerIndex).discardFromHand(table, deck);  
                if(players.get(playerIndex).isBot()) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }     
                System.out.println(System.lineSeparator().repeat(50));
            } catch (UnoCardException e) {
                if(e.getTException() == CardException.EMPTY_HAND) {
                    checkWinner = true;
                    winner = playerIndex;
                } else if(e.getTException() == CardException.UNO) {
                    System.out.println(">>>>>>>>>>UNO!!!!<<<<<<<<<<<<");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(System.lineSeparator().repeat(50));
                }
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
            
            rounds++;
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
        System.out.println("==========================================");
        System.out.println("Game over, player " + players.get(winner).getName() + " won!");
        System.out.println("==========================================");
    }
    
}
