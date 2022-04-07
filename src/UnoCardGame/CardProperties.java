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
        RED,
        GREEN,
        BLUE,
        YELLOW,
        NONE;
        
        public static CardColor fromInt(int x) {
            return switch (x) {
                case 0 -> RED;
                case 1 -> GREEN;
                case 2 -> BLUE;
                case 3 -> YELLOW;
                default -> NONE;
            };
        }
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
        NINE,
        NO_NUMBER;
        
        public static CardNumber fromInt(int x) {
            switch (x) {
                case 0 -> {
                    return ZERO;
                }
                case 1 -> {
                    return ONE;
                }
                case 2 -> {
                    return TWO;
                }
                case 3 -> {
                    return THREE;
                }
                case 4 -> {
                    return FOUR;
                }
                case 5 -> {
                    return FIVE;
                }
                case 6 -> {
                    return SIX;
                }
                case 7 -> {
                    return SEVEN;
                }
                case 8 -> {
                    return EIGHT;
                }
                case 9 -> {
                    return NINE;
                }
                default -> {
                    return NO_NUMBER;
                }
            }
        }   
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
