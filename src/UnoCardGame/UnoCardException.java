/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

/**
 *
 * @author Kimio Nishino
 */
public class UnoCardException extends Exception{
    
    public enum CardException {
        EMPTY_DECK,
        EMPTY_HAND,
        UNO
    }
    
    private CardException typeOfException;
    
    public UnoCardException(String message, CardException cause) {
        super(message);
        this.typeOfException = cause;
    }

    public CardException getTException() {
        return typeOfException;
    }
    
    
}
