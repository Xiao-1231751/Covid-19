package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * The test class to test the method in the stateDLList
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class StateDLListTest extends student.TestCase {

    private StateDLList list;
    private StateDLList test;
    private Race race;
    private Iterator<Race> iterator;

    /**
     * It will be called before every test method called
     */
    public void setUp() {
        list = new StateDLList("DC");
        race = new Race("Asian", 100, 10);
        iterator = list.iterator();
    }


    /**
     * Test if the getName() method can work correctly
     */
    public void testGetName() {
        assertEquals("DC", list.getName());
    }


    /**
     * Test if the isEmpty() method can work correctly in empty list and no
     * empty list
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(race);
        assertFalse(list.isEmpty());
    }


    /**
     * Test if the size() method can get correctly size
     */
    public void testSize() {
        assertEquals(0, list.size());
        list.add(race);
        assertEquals(1, list.size());
    }


    /**
     * Test if the clear() method can work correctly.
     */
    public void testClear() {
        list.add(race);
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }


    /**
     * Test if the contains() method can work correctly in different situations
     */
    public void testContains() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 10);
        Race race3 = new Race("Asian", 100, 10);
        Race race4 = new Race("Asian", 100, 10);
        Race race5 = new Race("Asian", 100, 10);
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertTrue(list.contains(race));
        assertTrue(list.contains(race2));
        assertTrue(list.contains(race3));
        assertFalse(list.contains(race5));
    }


    /**
     * Test if the get() method can work correctly
     */
    public void testGet() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 10);
        Race race3 = new Race("Asian", 100, 10);
        Race race4 = new Race("Asian", 100, 10);

        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertEquals(race1, list.get(1));
    }


    /**
     * Test if the getHead() method can work correctly
     */
    public void testGetHead() {
        list.add(race);
        assertNotNull(list.getHead());
    }


    /**
     * Test if the add() method can work correctly
     */
    public void testAdd() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 10);
        Race race3 = new Race("Asian", 100, 10);
        Race race4 = new Race("Asian", 100, 10);

        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertNotNull(list.getHead());
    }


    /**
     * Test if the add() method can work correctly in the error
     */
    public void testAddError() {
        Exception exception = null;
        try {
            list.add(3, race);
            fail("The index is out of range");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test if the add() method can work correctly in the error
     */
    public void testAddErrorOne() {
        Exception exception = null;
        try {
            list.add(-7, race);
            fail("The index is out of range");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test if the add() method can work correctly in the error
     */
    public void testAddErrorSecond() {
        Exception exception = null;
        try {
            Race race1 = new Race("Asian", 100, 10);
            Race race2 = new Race("Asian", 100, 10);
            Race race3 = new Race("Asian", 100, 10);
            Race race4 = new Race("Asian", 100, 10);

            list.add(race);
            list.add(race1);
            list.add(race2);
            list.add(race3);
            list.add(race4);
            list.add(3, null);
            fail("The object is null");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Cannot add null objects to a list",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Test if the removeIndex() method can work correctly
     */
    public void testRemoveIndex() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 10);
        Race race3 = new Race("Asian", 100, 10);
        Race race4 = new Race("Asian", 100, 10);

        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertTrue(list.remove(1));
        assertFalse(list.remove(-1));
        assertFalse(list.remove(10));
    }


    /**
     * Test if the get() method can work correctly in some situations
     */
    public void testRemoveObj() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 10);
        Race race3 = new Race("Asian", 100, 10);
        Race race4 = new Race("Asian", 100, 10);
        Race race5 = new Race("Asian", 100, 10);
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertTrue(list.remove(race));
        assertFalse(list.remove(race5));
        assertFalse(list.remove(null));
    }


    /**
     * Test if the toString() method can work correctly in empty
     */
    public void testToStringInEmpty() {
        assertNotNull(list.toString());
    }


    /**
     * Test if the toString() method can work correctly
     */
    public void testToStringInRace() {

        Race asian = new Race("Asian", 100, 9);
        Race white = new Race("White", 100, 13);
        Race black = new Race("Balck", 100, 11);
        Race latinx = new Race("Latinx", 100, 20);
        Race other = new Race("Other", 100, 16);
        test = new StateDLList("DC");
        test.add(asian);
        test.add(white);
        test.add(black);
        test.add(latinx);
        test.add(other);
        assertNotNull(test.toString());
    }


    /**
     * Test if the toString() method can work correctly
     */
    public void testTOStingInRaceSecond() {

        Race asian = new Race("Asian", -1, 9);
        Race white = new Race("White", 100, 13);
        Race black = new Race("Balck", 100, 11);
        Race latinx = new Race("Latinx", 100, -1);
        Race other = new Race("Other", 100, 16);
        test = new StateDLList("DC");
        test.add(asian);
        test.add(white);
        test.add(black);
        test.add(latinx);
        test.add(other);
        System.out.println(test.toString());
        assertNotNull(test.toString());
    }


    /**
     * Test if the sort() method can work correctly
     */
    public void testSort() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 20);
        Race race3 = new Race("Asian", 100, 1);
        Race race4 = new Race("Asian", 100, 30);
        list.sort();
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        list.sort();
        assertNotNull(list.toString());
    }


    /**
     * Test if the sortName() method can work correctly
     */
    public void testSortByName() {
        Race race1 = new Race("B", 100, 10);
        Race race2 = new Race("C", 100, 20);
        Race race3 = new Race("A", 100, 1);
        Race race4 = new Race("D", 100, 30);
        list.sortName();
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        list.sortName();
        assertNotNull(list.toString());
    }


    /**
     * Test if the hasNext() method of iterator can work correctly
     */
    public void testHasNext() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 20);
        Race race3 = new Race("Asian", 100, 1);
        Race race4 = new Race("Asian", 100, 30);
        assertFalse(iterator.hasNext());
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertTrue(iterator.hasNext());
    }


    /**
     * Test if the next() method of iterator can work correctly
     */
    public void testNext() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 20);
        Race race3 = new Race("Asian", 100, 1);
        Race race4 = new Race("Asian", 100, 30);
        list.add(race);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(race4);
        assertEquals(race, iterator.next());
    }


    /**
     * Test if the next() method of iterator can work correctly in erroe
     */
    public void testNextError() {
        Exception exception = null;
        try {
            iterator.next();
            fail("The object is null");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("Cannot add null objects to a list",
            exception instanceof NoSuchElementException);
    }


    /**
     * Test if the add() method can work correctly by using index
     */
    public void testAddByIndex() {
        Race race1 = new Race("Asian", 100, 10);
        Race race2 = new Race("Asian", 100, 20);
        Race race3 = new Race("Asian", 100, 1);
        Race race4 = new Race("Asian", 100, 30);
        list.add(race1);
        list.add(race2);
        list.add(race3);
        list.add(2, race4);
        assertEquals(4, list.size());
    }

}
