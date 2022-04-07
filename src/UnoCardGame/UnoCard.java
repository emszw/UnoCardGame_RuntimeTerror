/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnoCardGame;

import CardGame.Card;

/**
 *
 * @author Kimio Nishino
 */
public class UnoCard extends Card{
    private CardColor color;
    private CardNumber number;
    private CardRank rank;
    private boolean actionTaken;

    public UnoCard(CardColor color, CardNumber number, CardRank rank) {
        this.color = color;
        this.number = number;
        this.rank = rank;
        if(rank != CardRank.NUMBER)
            actionTaken = false;
    }

    public boolean isActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(boolean actionTaken) {
        this.actionTaken = actionTaken;
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
     * Checks if card is either a WILD or WILD_DRAW4 card
     * @param card to be checked
     * @return true for wild or wild_draw4, false otherwise 
     */
    public boolean isWild() {
        return (getRank() == CardRank.WILD || getRank() == CardRank.WILD_DRAW4);
    }

    @Override
    public String toString() {
        return "Color: " + color + ", Number: " + number + ", Rank: " + rank;
    }
    
}
