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
public class UnoCardGame extends Game {

    private static GroupOfCards deck;
    private static ArrayList<UnoPlayer> players;
    private static ArrayList<UnoCard> table;
    private static boolean clockwise = true;
    private static boolean checkWinner = false;
    private static int rounds = 0;
    private static int playerIndex = 0;

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
        if (botChoice == 1) {
            botMode = true;
        }
        System.out.println("Initializing players...");

        for (int i = 0; i < 4; i++) {
            players.add(new UnoPlayer(args[i]));
            if (i == 0) {
                players.get(0).setBot(botMode);
            }
            try {
                players.get(i).drawToHand(deck, 7);
            } catch (UnoCardException e) {
                System.out.println("Unexpected exception when initializing players");
                System.out.println(e.getMessage() + "\n" + e.getTException());
            }
            System.out.println("Name for player " + i + ": " + players.get(i).getName());

        }
        try {
            //making sure I'm pulling a number card to the top of table
            do {
                deck.shuffle();
            } while (deck.getCards().get(0).getRank() != CardRank.NUMBER);
            table.add(deck.drawCard());
        } catch (UnoCardException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause of exception: " + e.getTException());
        }
    }

    public static void displayRound() {
        System.out.println("==========ROUND " + rounds + "==============");
        System.out.println("Current ammount of cards on Deck: " + deck.getSize());
        System.out.println("============================");
        for (UnoPlayer player : players) {
            if (player.getSize() == 1) {
                System.out.print("Number of cards on the hands of player " + player.getName() + ": " + player.getSize());
                System.out.println(" [UNO!!!]");
            } else {
                System.out.println("Number of cards on the hands of player " + player.getName() + ": " + player.getSize());
            }
        }
        System.out.println("============================");
        System.out.println("Current player order:");
        for (UnoPlayer player : players) {
            if (players.indexOf(player) == playerIndex) {
                System.out.print("[" + player.getName() + "]");
            } else {
                System.out.print(player.getName());
            }
            if (clockwise) {
                System.out.print(" -> ");
            } else {
                System.out.print(" <- ");
            }
        }
        System.out.println();
        players.get(playerIndex).displayHand();
        System.out.println("=================================");
        System.out.println(">>>>Card on top of the table: " + table.get(table.size() - 1).toString() + "<<<<<");

    }

    @Override
    public void play() {
        System.out.println("Game starting!!");
        while (!checkWinner) {
            displayRound();
            //if the card on top of the table is a skip card and wasn't used before
            //it will just update the action to used.
            //otherwise, it will just try to discard a player's card as usual
            if (table.get(table.size() - 1).isSkippable()) {
                displaySkip();
                System.out.println("Skipping player " + players.get(playerIndex).getName());
                table.get(table.size() - 1).setActionTaken(true);
            } 
            //if the card on top is either a draw2 or wild_draw4, and wasn't used
            //before, it will update the action to true, and try to pull the
            //ammount of cards to the player. It will also skip to the next player;
            else if (table.get(table.size() - 1).isDrawable()) {
                System.out.println("Drawable card on the table!");
                pullCards();
                table.get(table.size() - 1).setActionTaken(true);
            } else {
                try {
                    players.get(playerIndex).discardFromHand(table, deck);
                } catch (UnoCardException e) {
                    if (e.getTException() == CardException.EMPTY_HAND) {
                        checkWinner = true;
                    }
                }

                //If the new top of the table is a reverse card and
                //the card wasn't reversed yet, reverse the rotation for next player
                if (table.get(table.size() - 1).getRank() == CardRank.REVERSE
                        && !table.get(table.size() - 1).isActionTaken()) {
                    clockwise = !clockwise;
                    table.get(table.size() - 1).setActionTaken(true);
                    displayReverse();
                    System.out.println(">>>Order reversed!!<<<");
                }
            }
            if (!checkWinner) {
                int curPlayer = playerIndex;
                nextPlayer();
                System.out.println("Next player will be " + players.get(playerIndex).getName());
                //If the current player is a bot, thread will sleep for 2s
                //before printing a newline
                if (players.get(curPlayer).isBot()) {
                    try {
                        Thread.sleep(5000);
                        System.out.println(System.lineSeparator().repeat(50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(System.lineSeparator().repeat(50));
                }
            }
        }
        declareWinner();
    }
    
    public void displaySkip() {
        System.out.println("⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀\n" +
"⢠⣾⡿⠿⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀\n" +
"⢸⣿⢠⠞⣩⡄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠉⠀⠀⠀⠀⠉⠛⢿⡆\n" +
"⢸⣿⣄⣈⣉⣴⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⣿⡟⠁⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⣿⡏⠀⠀⢀⣴⣿⣿⣿⣿⣿⠿⠿⠿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀\n" +
"⢸⣿⠏⠀⠀⢠⣿⣿⣿⣿⠟⠁⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
"⢸⡟⠀⠀⢠⣿⣿⣿⡟⠁⠀⢀⣠⣾⣿⣿⣿⡿⠋⣿⣿⣿⡇⠀⠀⠀⠀⠀\n" +
"⠘⠀⠀⠀⢸⣿⣿⣿⠁⢀⣴⣿⣿⢿⣿⠿⠋⠀⢀⣿⣿⣿⠇⠀⠀⠀⣼⠀\n" +
"⠀⠀⠀⠀⢸⣿⣿⣿⣶⣿⣿⣿⣿⠟⠁⠀⠀⢠⣾⣿⣿⡿⠀⠀⠀⣼⣿⠀\n" +
"⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⠟⠁⠀⣀⣠⣶⣿⣿⣿⡿⠁⠀⠀⣼⣿⣿⠀\n" +
"⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⢀⣾⣿⣿⣿⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⣿⣿⣿⣿⣿⠿⠟⠋⠀⠀⠀⣠⣾⣿⣿⣿⣿⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
"⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⠟⣋⠛⢿⣿⠀\n" +
"⢸⣷⣤⣀⡀⠀⠀⠀⣀⣠⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠞⣡⡼⢸⣿⠀\n" +
"⠈⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣥⣴⣿⠟⠀");
    }
    
    public void displayReverse() {
        System.out.println("⠐⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠂\n" +
"⠄⠄⣰⣾⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣆⠄⠄\n" +
"⠄⠄⣿⣿⣿⡿⠋⠄⡀⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠋⣉⣉⣉⡉⠙⠻⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⣿⣇⠔⠈⣿⣿⣿⣿⣿⡿⠛⢉⣤⣶⣾⣿⣿⣿⣿⣿⣿⣦⡀⠹⠄⠄\n" +
"⠄⠄⣿⣿⠃⠄⢠⣾⣿⣿⣿⠟⢁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠄⠄\n" +
"⠄⠄⣿⣿⣿⣿⣿⣿⣿⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⠄\n" +
"⠄⠄⣿⣿⣿⣿⣿⡟⠁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⣿⣿⠋⢠⣾⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⡿⠁⣰⣿⣿⣿⣿⣿⣿⣿⣿⠗⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⡟⠄⠄\n" +
"⠄⠄⣿⡿⠁⣼⣿⣿⣿⣿⣿⣿⡿⠋⠄⠄⠄⣠⣄⢰⣿⣿⣿⣿⣿⣿⣿⠃⠄⠄\n" +
"⠄⠄⡿⠁⣼⣿⣿⣿⣿⣿⣿⣿⡇⠄⢀⡴⠚⢿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢠⠄⠄\n" +
"⠄⠄⠃⢰⣿⣿⣿⣿⣿⣿⡿⣿⣿⠴⠋⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⡟⢀⣾⠄⠄\n" +
"⠄⠄⢀⣿⣿⣿⣿⣿⣿⣿⠃⠈⠁⠄⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⡟⢀⣾⣿⠄⠄\n" +
"⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⠄⢶⣿⣿⣿⣿⣿⣿⣿⣿⠏⢀⣾⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⠋⣠⣿⣿⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣼⣿⣿⣿⣿⣿⠄⠄\n" +
"⠄⠄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⠄⠄\n" +
"⠄⠄⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢁⣴⣿⣿⣿⣿⠗⠄⠄⣿⣿⠄⠄\n" +
"⠄⠄⣆⠈⠻⢿⣿⣿⣿⣿⣿⣿⠿⠛⣉⣤⣾⣿⣿⣿⣿⣿⣇⠠⠺⣷⣿⣿⠄⠄\n" +
"⠄⠄⣿⣿⣦⣄⣈⣉⣉⣉⣡⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⠉⠁⣀⣼⣿⣿⣿⠄⠄\n" +
"⠄⠄⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣾⣿⣿⡿⠟⠄⠄\n" +
"⠠⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄");
    }
    
    
    
    public void nextPlayer() {
        if (clockwise) {
            playerIndex++;
            if (playerIndex >= 4) {
                playerIndex = 0;
            }
        } else {
            playerIndex--;
            if (playerIndex < 0) {
                playerIndex = 3;
            }
        }
        rounds++;
    }

    public void pullCards() {
        try {
            if (table.get(table.size() - 1).getRank() == CardRank.DRAW2) {
                players.get(playerIndex).drawToHand(deck, 2);
                System.out.println("Player " + players.get(playerIndex).getName()
                        + " pulled two cards from the deck");
            } else {
                players.get(playerIndex).drawToHand(deck, 4);
                System.out.println("Player " + players.get(playerIndex).getName()
                        + " pulled four cards from the deck");
            }
        }
        //this code makes baby jesus very sad
        catch (UnoCardException e) {
            System.out.println(e.getMessage());
            //if the deck is empty while pulling from it,
            //the table deck will be remixed with the deck, and one card
            //will be pulled to the table.
            //that's a soft reset of the table
            if (e.getTException() == CardException.EMPTY_DECK) {
                table = deck.remixDeck(table);
                //after remixing the deck with the table cards,  
                //try again
                try {
                    if (table.get(table.size() - 1).getRank() == CardRank.DRAW2) {
                        players.get(playerIndex).drawToHand(deck, 2);
                        System.out.println("Player " + players.get(playerIndex).getName()
                                + " pulled two cards from the deck");
                    } else {
                        players.get(playerIndex).drawToHand(deck, 4);
                        System.out.println("Player " + players.get(playerIndex).getName()
                                + " pulled four cards from the deck");
                    }
                } catch (UnoCardException ex) {
                    System.out.println("This should NEVER HAPPEN"); //lol
                    ex.printStackTrace();
                }
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
        System.out.println("Game over, player " + players.get(playerIndex).getName() + " won!");
        System.out.println("==========================================");
    }

}
