package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * The test class to test the methods in the stateArray
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class StateArrayTest extends student.TestCase {

    private StateArray array;

    /**
     * It will be called before each test method
     */
    public void setUp() {
        array = new StateArray();
    }


    /**
     * Test if the add method is work correctly
     */
    public void testAdd() {
        StateDLList test1 = new StateDLList("DC");
        Race asian = new Race("Asian", 100, 10);
        Race white = new Race("White", 100, 18);
        test1.add(white);
        test1.add(asian);
        array.add(test1);

        StateDLList test2 = new StateDLList("GA");
        Race asian1 = new Race("Asian", 100, 10);
        Race white1 = new Race("White", 100, 18);
        test2.add(white1);
        test2.add(asian1);
        array.add(test2);

        StateDLList test3 = new StateDLList("GA");
        Race asian2 = new Race("Asian", 100, 10);
        Race white2 = new Race("White", 100, 18);
        test3.add(white2);
        test3.add(asian2);
        array.add(test3);
        assertEquals(test1, array.getElement(0));
        System.out.println(array.toString());
    }


    /**
     * Test if the add method is work correctly when the array is full
     */
    public void testAddFull() {
        StateDLList test1 = new StateDLList("DC");
        StateDLList test2 = new StateDLList("DC");
        StateDLList test3 = new StateDLList("DC");
        StateDLList test4 = new StateDLList("DC");
        StateDLList test5 = new StateDLList("DC");
        StateDLList test6 = new StateDLList("DC");
        StateDLList test7 = new StateDLList("DC");
        array.add(test1);
        array.add(test2);
        array.add(test3);
        array.add(test4);
        array.add(test5);
        array.add(test6);
        assertFalse(array.add(test7));
    }


    /**
     * Test if the isEmpty() method work correctly
     */
    public void testIsEmpty() {
        assertTrue(array.isEmpty());
    }


    /**
     * Test if the getElement() method can throw correct error
     */
    public void testGetElementError() {
        Exception exception = null;
        try {
            array.getElement(100);
            fail("getElement() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getElement() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test if the getElement() method can throw correct error
     */
    public void testGetElementErrorAgain() {
        Exception exception = null;
        try {
            array.getElement(-10);
            fail("getElement() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getElement() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test if the toString method work in empty
     */
    public void testToStringInempty() {
        assertEquals("", array.toString());
    }

}
