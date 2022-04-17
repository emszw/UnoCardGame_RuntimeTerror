
package UnoCardGame;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emily
 */
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of fillDeck method, of class GroupOfCards.
     */
    @Test
    public void testFillDeckGood() {
        System.out.println("fillDeck Good");
        GroupOfCards instance = new GroupOfCards();
        ArrayList<UnoCard> cards = new ArrayList<>();
        instance.fillDeck();
    }

    @Test
    public void testFillDeckBad() {
        System.out.println("fillDeck");
        GroupOfCards instance = new GroupOfCards();
        instance.fillDeck();
    }

    /**
     * Test of printGroup method, of class GroupOfCards.
     */
    @Test
    public void testPrintGroup() {
        System.out.println("printGroup");
        GroupOfCards instance = new GroupOfCards();
        instance.printGroup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCard method, of class GroupOfCards.
     */
    @Test
    public void testDrawCard() throws Exception {
        System.out.println("drawCard");
        GroupOfCards instance = new GroupOfCards();
        UnoCard expResult = null;
        UnoCard result = instance.drawCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCardToDeck method, of class GroupOfCards.
     */
    @Test
    public void testAddCardToDeck() {
        System.out.println("addCardToDeck");
        UnoCard card = null;
        GroupOfCards instance = new GroupOfCards();
        instance.addCardToDeck(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remixDeck method, of class GroupOfCards.
     */
    @Test
    public void testRemixDeck() {
        System.out.println("remixDeck");
        ArrayList<UnoCard> tableDeck = null;
        GroupOfCards instance = new GroupOfCards();
        ArrayList<UnoCard> expResult = null;
        ArrayList<UnoCard> result = instance.remixDeck(tableDeck);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class GroupOfCards.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        GroupOfCards instance = new GroupOfCards();
        ArrayList<UnoCard> expResult = null;
        ArrayList<UnoCard> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class GroupOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        GroupOfCards instance = new GroupOfCards();
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class GroupOfCards.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        GroupOfCards instance = new GroupOfCards();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class GroupOfCards.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        GroupOfCards instance = new GroupOfCards();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GroupOfCards.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GroupOfCards instance = new GroupOfCards();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
