package UnoCardGame;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */

import java.util.ArrayList;
import java.util.Collections;
import UnoCardGame.CardProperties.*;
import UnoCardGame.UnoCardException.*;


/**
 * A concrete class that represents any grouping of cards for a Game. HINT,
 * you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which 
 * is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author emszw Emily Szwalek Feb 2022
 * @modifier Kimio Nishino April 2022
 */
public class GroupOfCards {
    
    /**
     * The number of non-zero number cards of each suit in the deck.
     */
    public static final int NUMBER_OF_DUP_REGULAR_CARDS = 2;

    /**
     * The number of zero number cards of each suit in the deck.
     */
    public static final int NUMBER_OF_DUP_ZERO_CARDS = 1;

    /**
     * The number of "special" cards (aka "action cards") of each suit in
     * the deck. These include, for instance, Skips and Reverses.
     */
    public static final int NUMBER_OF_DUP_SPECIAL_CARDS = 2;

    /**
     * The number of wild cards (standard and draw 4) in the deck.
     */
    public static final int NUMBER_OF_WILD_CARDS = 4;

    
    
    //The group of cards, stored in an ArrayList
    private ArrayList<UnoCard> cards;
    private int size;//the size of the grouping
       
    public GroupOfCards(){
        cards = new ArrayList<>(); 
    }
    
    /**
     * Main method from the GroupOfCards.
     * It creates a full deck following the rules of the official
     * UNO Card Game. It makes use of the constants in this class
     * to generate the correct ammount of cards for each rank and color.
     */
    public void fillDeck() {
        System.out.println("Initializing deck...");
        //GENERATING NUMBER CARDS FROM 1 - 9
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < NUMBER_OF_DUP_REGULAR_CARDS; j++) {
                cards.add(new UnoCard(CardColor.RED, CardNumber.fromInt(i), CardRank.NUMBER));
                cards.add(new UnoCard(CardColor.GREEN, CardNumber.fromInt(i), CardRank.NUMBER));
                cards.add(new UnoCard(CardColor.BLUE, CardNumber.fromInt(i), CardRank.NUMBER));
                cards.add(new UnoCard(CardColor.YELLOW, CardNumber.fromInt(i), CardRank.NUMBER));
            }
        }
        //GENERATING NUMBER CARDS 0
        for (int i = 0; i < NUMBER_OF_DUP_ZERO_CARDS; i++) {
            cards.add(new UnoCard(CardColor.RED, CardNumber.fromInt(i), CardRank.NUMBER));
            cards.add(new UnoCard(CardColor.GREEN, CardNumber.fromInt(i), CardRank.NUMBER));
            cards.add(new UnoCard(CardColor.BLUE, CardNumber.fromInt(i), CardRank.NUMBER));
            cards.add(new UnoCard(CardColor.YELLOW, CardNumber.fromInt(i), CardRank.NUMBER));
        }
        //GENERATING SPECIAL CARDS
        for (int i = 0; i < NUMBER_OF_DUP_SPECIAL_CARDS; i++) {
            //SKIP CARDS
            cards.add(new UnoCard(CardColor.RED, CardNumber.NO_NUMBER, CardRank.SKIP));
            cards.add(new UnoCard(CardColor.GREEN, CardNumber.NO_NUMBER, CardRank.SKIP));
            cards.add(new UnoCard(CardColor.BLUE, CardNumber.NO_NUMBER, CardRank.SKIP));
            cards.add(new UnoCard(CardColor.YELLOW, CardNumber.NO_NUMBER, CardRank.SKIP));
            //REVERSE CARDS
            cards.add(new UnoCard(CardColor.RED, CardNumber.NO_NUMBER, CardRank.REVERSE));
            cards.add(new UnoCard(CardColor.GREEN, CardNumber.NO_NUMBER, CardRank.REVERSE));
            cards.add(new UnoCard(CardColor.BLUE, CardNumber.NO_NUMBER, CardRank.REVERSE));
            cards.add(new UnoCard(CardColor.YELLOW, CardNumber.NO_NUMBER, CardRank.REVERSE));
            //DRAW TWO CARDS
            cards.add(new UnoCard(CardColor.RED, CardNumber.NO_NUMBER, CardRank.DRAW2));
            cards.add(new UnoCard(CardColor.GREEN, CardNumber.NO_NUMBER, CardRank.DRAW2));
            cards.add(new UnoCard(CardColor.BLUE, CardNumber.NO_NUMBER, CardRank.DRAW2));
            cards.add(new UnoCard(CardColor.YELLOW, CardNumber.NO_NUMBER, CardRank.DRAW2));
        }
        for (int i = 0; i < NUMBER_OF_WILD_CARDS; i++) {
            cards.add(new UnoCard(CardColor.NONE, CardNumber.NO_NUMBER, CardRank.WILD));
            cards.add(new UnoCard(CardColor.NONE, CardNumber.NO_NUMBER, CardRank.WILD_DRAW4));
        }
        this.size = cards.size();
        System.out.println("Deck with " + this.size + " cards initialized.");
    }
    
    /**
     * Method used for debugging only
     */
    public void printGroup() {
        for (UnoCard card : cards) 
            System.out.println(card.toString());
    }
    
    /**
     * Method that draws one card from the top of the deck in the 
     * GroupOfCards, and throws an exception if the deck is not
     * bigger than zero.
     * @return card on top of the ArrayList<UnoCard> deck
     * @throws UnoCardException
     */
    public UnoCard drawCard() throws UnoCardException{
        if(this.size > 0) {
            this.size--;
            return cards.remove(0);
        } else {
            throw new UnoCardException("Group of Cards size is zero!", CardException.EMPTY_DECK);
        }   
    }
    
    /**
     * Method used in case the first card pulled to the table is a WILD CARD
     * It gets the card back to the deck, and shuffles it.
     * @param card - Card that was just removed from the deck is put back
     * to the list
     */
    public void addCardToDeck(UnoCard card) {
        cards.add(card);
        size++;
        shuffle();
    }
    
    public void remixDeck(ArrayList<UnoCard> tableDeck) {
        if(cards.isEmpty()) {
            System.out.println("Deck was empty, remixing it with the table deck!");
            cards.addAll(tableDeck);
            size = cards.size();
            shuffle();
        }
    }
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<UnoCard> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}//end class
