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
 * The test class to test the method in Race class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class RaceTest extends student.TestCase {
    private Race race;

    /**
     * It will be called before every test method
     */
    public void setUp() {
        race = new Race("Asian", 100, 10);
    }


    /**
     * Test if the getName() method work correctly
     */
    public void testGetName() {
        assertEquals("Asian", race.getName());
    }


    /**
     * Test if the getCases() method work correctly
     */
    public void testGetCases() {
        assertEquals(100, race.getCases());
    }


    /**
     * Test if the getDeaths() method work correctly
     */
    public void testGetDeaths() {
        assertEquals(10, race.getDeaths());
    }


    /**
     * Test if the calcularotCFR() method work correctly
     */
    public void testCalculatorCFR() {
        assertEquals("10", race.calculatorCFR());
        Race newRace = new Race("Asian", 100, 0);
        assertEquals("0", newRace.calculatorCFR());
    }


    /**
     * Test if the calcularotCFR() method work correctly in some situations
     */
    public void testCalculatorCFRNA() {
        Race newRace = new Race("Asian", -1, 0);
        Race secondRace = new Race("Asian", 100, -1);
        assertEquals("-1", newRace.calculatorCFR());
        assertEquals("-1", secondRace.calculatorCFR());
    }


    /**
     * Test if the toString() method can work correctly
     */
    public void testToString() {
        assertEquals("Asian: 100 cases, 10% CFR", race.toString());
    }


    /**
     * Test if the toString() method can work correctly in the NA situation
     */
    public void testToStringNA() {
        Race newRace = new Race("Asian", -1, 0);
        Race secondRace = new Race("Asian", 100, -1);
        assertEquals("Asian: -1 cases, -1% CFR", newRace.toString());
        assertEquals("Asian: 100 cases, -1% CFR", secondRace.toString());
    }


    /**
     * Test if the compareTo() method can work correctly
     */
    public void testCompareTo() {
        Race newRace = new Race("Asian", 100, 10);
        Race secondRace = new Race("Asian", 100, 20);
        assertEquals(-1, newRace.compareTo(secondRace));
        assertEquals(1, secondRace.compareTo(newRace));
        Race thirdRace = new Race("Asian", 100, 20);
        assertEquals(0, secondRace.compareTo(thirdRace));
    }


    /**
     * Test if the getRealName() method can work correctly
     */
    public void testGetRealName() {
        Race newRace = new Race("Asian", 100, 10);
        Race newRace1 = new Race("Black", 100, 10);
        Race newRace2 = new Race("White", 100, 10);
        Race newRace3 = new Race("Other", 100, 10);
        Race newRace4 = new Race("LatinX", 100, 10);
        assertEquals("asian", newRace.getRealName());
        assertEquals("black", newRace1.getRealName());
        assertEquals("white", newRace2.getRealName());
        assertEquals("other", newRace3.getRealName());
        assertEquals("latinx", newRace4.getRealName());
    }

}
