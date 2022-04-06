package UnoCardGame;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */

import java.util.ArrayList;
import java.util.Collections;
import CardGame.Card;


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
public class GroupOfCards extends Card {
    
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
    
    
    public void fillDeck() {
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
    }
    
    
    public void printGroup() {
        for (UnoCard card : cards) {
            System.out.println(card.toString());
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
