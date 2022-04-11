/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UnoCardGame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emily
 */
public class UnoCardTest {
    
    public UnoCardTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of isActionTaken method, of class UnoCard.
     */
    @Test
    public void testIsActionTakenGood() {
        System.out.println("isActionTaken Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        instance.setActionTaken(true);
        boolean expResult = true;
        boolean result = instance.isActionTaken();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsActionTakenBad() {
        System.out.println("isActionTaken Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        instance.setActionTaken(false);
        boolean expResult = false;
        boolean result = instance.isActionTaken();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void testGetColorGood() {
        System.out.println("getColor Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardColor expCardResult = CardProperties.CardColor.RED;
        boolean expResult = true;
        boolean result = (expCardResult == instance.getColor());
        assertEquals(expResult, result);
    }
    @Test
    public void testGetColorBad() {
        System.out.println("getColor Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardColor expCardResult = CardProperties.CardColor.BLUE;
        boolean expResult = false;
        boolean result = (expCardResult == instance.getColor());
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class UnoCard.
     */
    @Test
    public void testSetColorGood() {
        System.out.println("setColor Good");
        CardProperties.CardColor color = null;
        CardProperties.CardNumber number = CardProperties.CardNumber.fromInt(7);
        CardProperties.CardRank rank = CardProperties.CardRank.NUMBER;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setColor(CardProperties.CardColor.RED);
        CardProperties.CardColor expCardResult = CardProperties.CardColor.RED;
        boolean expResult = true;
        boolean result = (expCardResult == instance.getColor());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetColorBad() {
        System.out.println("setColor Bad");
        CardProperties.CardColor color = null;
        CardProperties.CardNumber number = CardProperties.CardNumber.NO_NUMBER;
        CardProperties.CardRank rank = CardProperties.CardRank.REVERSE;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setColor(CardProperties.CardColor.RED);
        CardProperties.CardColor expCardResult = CardProperties.CardColor.GREEN;
        boolean expResult = false;
        boolean result = (expCardResult == instance.getColor());
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class UnoCard.
     */
    @Test
    public void testGetNumberGood() {
        System.out.println("getNumber Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardNumber expCardResult = CardProperties.CardNumber.fromInt(2);
        boolean expResult = true;
        boolean result = (expCardResult == instance.getNumber());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNumberBad() {
        System.out.println("getNumber Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardNumber expCardResult = CardProperties.CardNumber.fromInt(6);
        boolean expResult = false;
        boolean result = (expCardResult == instance.getNumber());
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class UnoCard.
     */
    @Test
    public void testSetNumberGood() {
        System.out.println("setNumber Good");
        CardProperties.CardColor color = CardProperties.CardColor.RED;
        CardProperties.CardNumber number = null;
        CardProperties.CardRank rank = CardProperties.CardRank.NUMBER;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setNumber(CardProperties.CardNumber.fromInt(7));
        CardProperties.CardNumber expCardResult = CardProperties.CardNumber.fromInt(7);
        boolean expResult = true;
        boolean result = (expCardResult == instance.getNumber());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetNumberBad() {
        System.out.println("setNumber Bad");
        CardProperties.CardColor color = CardProperties.CardColor.RED;
        CardProperties.CardNumber number = null;
        CardProperties.CardRank rank = CardProperties.CardRank.NUMBER;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setNumber(CardProperties.CardNumber.fromInt(7));
        CardProperties.CardNumber expCardResult = CardProperties.CardNumber.fromInt(4);
        boolean expResult = false;
        boolean result = (expCardResult == instance.getNumber());
        assertEquals(expResult, result);
    }

    /**
     * Test of getRank method, of class UnoCard.
     */
    @Test
    public void testGetRankGood() {
        System.out.println("getRank Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardRank expCardResult = CardProperties.CardRank.NUMBER;
        boolean expResult = true;
        boolean result = (expCardResult == instance.getRank());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRankBad() {
        System.out.println("getRank Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        CardProperties.CardRank expCardResult = CardProperties.CardRank.REVERSE;
        boolean expResult = false;
        boolean result = (expCardResult == instance.getRank());
        assertEquals(expResult, result);
    }

    /**
     * Test of setRank method, of class UnoCard.
     */
    @Test
    public void testSetRankGood() {
        System.out.println("setRank Good");
        CardProperties.CardColor color = CardProperties.CardColor.RED;
        CardProperties.CardNumber number = CardProperties.CardNumber.NO_NUMBER;
        CardProperties.CardRank rank = null;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setRank(CardProperties.CardRank.REVERSE);
        CardProperties.CardRank expCardResult = CardProperties.CardRank.REVERSE;
        boolean expResult = true;
        boolean result = (expCardResult == instance.getRank());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetRankBad() {
        System.out.println("setRank Bad");
        CardProperties.CardColor color = CardProperties.CardColor.RED;
        CardProperties.CardNumber number = CardProperties.CardNumber.NO_NUMBER;
        CardProperties.CardRank rank = null;
        UnoCard instance = new UnoCard(color, number, rank);
        instance.setRank(CardProperties.CardRank.SKIP);
        CardProperties.CardRank expCardResult = CardProperties.CardRank.REVERSE;
        boolean expResult = false;
        boolean result = (expCardResult == instance.getRank());
        assertEquals(expResult, result);
    }
    

    /**
     * Test of isWild method, of class UnoCard.
     */
    @Test
    public void testIsWildGood() {
        System.out.println("isWild Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.NO_NUMBER, CardProperties.CardRank.WILD_DRAW4);
        boolean expResult = true;
        boolean result = instance.isWild();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsWildBad() {
        System.out.println("isWild Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.NO_NUMBER, CardProperties.CardRank.SKIP);
        boolean expResult = false;
        boolean result = instance.isWild();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDrawable method, of class UnoCard.
     */
    @Test
    public void testIsDrawableGood() {
        System.out.println("isDrawable Good");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.NO_NUMBER, CardProperties.CardRank.DRAW2);
        instance.setActionTaken(false);
        boolean expResult = true;
        boolean result = instance.isDrawable();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsDrawableBad() {
        System.out.println("isDrawable Bad");
        UnoCard instance = new UnoCard(CardProperties.CardColor.RED, CardProperties.CardNumber.fromInt(2), CardProperties.CardRank.NUMBER);
        instance.setActionTaken(false);
        boolean expResult = false;
        boolean result = instance.isDrawable();
        assertEquals(expResult, result);
    }
    
    
}
