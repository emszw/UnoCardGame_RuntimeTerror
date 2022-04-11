/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UnoCardGame;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emily
 */
public class UnoPlayerTest {
    
    public UnoPlayerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getSize method, of class UnoPlayer.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        UnoPlayer instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBot method, of class UnoPlayer.
     */
    @Test
    public void testIsBot() {
        System.out.println("isBot");
        UnoPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isBot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBot method, of class UnoPlayer.
     */
    @Test
    public void testSetBot() {
        System.out.println("setBot");
        boolean bot = false;
        UnoPlayer instance = null;
        instance.setBot(bot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawToHand method, of class UnoPlayer.
     */
    @Test
    public void testDrawToHand() throws Exception {
        System.out.println("drawToHand");
        GroupOfCards deck = null;
        int ammount = 0;
        UnoPlayer instance = null;
        instance.drawToHand(deck, ammount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayHand method, of class UnoPlayer.
     */
    @Test
    public void testDisplayHand() {
        System.out.println("displayHand");
        UnoPlayer instance = null;
        instance.displayHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discardFromHand method, of class UnoPlayer.
     */
    @Test
    public void testDiscardFromHand() throws Exception {
        System.out.println("discardFromHand");
        ArrayList<UnoCard> table = null;
        GroupOfCards deck = null;
        UnoPlayer instance = null;
        instance.discardFromHand(table, deck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class UnoPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        UnoPlayer instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
