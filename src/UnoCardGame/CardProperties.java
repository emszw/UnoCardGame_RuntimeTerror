/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

/**
 *
 * @author nishino
 */
public class CardProperties {
    protected enum CardColor {
        REG,
        GREEN,
        BLUE,
        YELLOW
    }
    
    protected enum CardNumber {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    }
    
    protected enum CardRank {
        NUMBER,
        WILD,
        WILD_DRAW4,
        REVERSE,
        SKIP,
        DRAW2
    }
}
