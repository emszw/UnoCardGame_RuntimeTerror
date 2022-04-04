
import UnoCardGame.CardProperties;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */








/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author emszw Emily Szwalek Feb 2022
 * @modifier Kimio Nishino Feb 2022
 */
public class Card extends CardProperties{
    //default modifier for child classes
    private CardColor color;
    private CardNumber number;
    private CardRank rank;

    public Card(CardColor color, CardNumber number, CardRank rank) {
        this.color = color;
        this.number = number;
        this.rank = rank;
    }
    
    
    
    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardNumber getNumber() {
        return number;
    }

    public void setNumber(CardNumber number) {
        this.number = number;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }
    
    
    
    

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
//    @Override
//    public abstract String toString();

}