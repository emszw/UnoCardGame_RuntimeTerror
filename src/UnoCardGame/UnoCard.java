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

    public UnoCard(CardColor color, CardNumber number, CardRank rank) {
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

    @Override
    public String toString() {
        return "Color: " + color + ", Number: " + number + ", Rank: " + rank;
    }
    
}
