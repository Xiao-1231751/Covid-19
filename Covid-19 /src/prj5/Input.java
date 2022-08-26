package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * The input Class to run the whole codes
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class Input {

    /**
     * Create a constructor to the input class
     */
    public void ProjectRuner() {
        /**
         * This is empty
         */
    }


    /**
     * The method to run the all codes
     * 
     */
    @SuppressWarnings("unused")
    public static void main(String[] file) throws FileNotFoundException {
        if (file.length == 1) {

            FileReader reader = new FileReader(file[0]);
        }
        else {
            FileReader reader = new FileReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            StateArray runner = reader.returnArray();

            GUIWindow window = new GUIWindow(runner);

        }

    }
}
