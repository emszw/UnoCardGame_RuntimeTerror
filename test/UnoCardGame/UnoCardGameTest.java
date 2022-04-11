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
public class UnoCardGameTest {
    
    public UnoCardGameTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of initializeGame method, of class UnoCardGame.
     */
    @Test
    public void testInitializeGame() {
        System.out.println("initializeGame");
        String[] args = null;
        UnoCardGame instance = new UnoCardGame();
        instance.initializeGame(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRound method, of class UnoCardGame.
     */
    @Test
    public void testDisplayRound() {
        System.out.println("displayRound");
        UnoCardGame.displayRound();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class UnoCardGame.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        UnoCardGame instance = new UnoCardGame();
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextPlayer method, of class UnoCardGame.
     */
    @Test
    public void testNextPlayer() {
        System.out.println("nextPlayer");
        UnoCardGame instance = new UnoCardGame();
        instance.nextPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pullCards method, of class UnoCardGame.
     */
    @Test
    public void testPullCards() {
        System.out.println("pullCards");
        UnoCardGame instance = new UnoCardGame();
        instance.pullCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of declareWinner method, of class UnoCardGame.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        UnoCardGame instance = new UnoCardGame();
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
