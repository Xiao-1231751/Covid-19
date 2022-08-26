package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * It is the class to read the information from the text document
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.020.2022
 */

public class FileReader {
    private StateArray newOne;

    /**
     * Create a constructor to the FileReader class
     * 
     * @param fileName
     * @throws FileNotFoundException
     */
    public FileReader(String fileName) throws FileNotFoundException {
        newOne = this.readCovidFile(fileName);
    }


    public StateArray returnArray() {
        return newOne;
    }


    /**
     * Create a new method to read the information of the file
     * 
     * @param fileName
     * @return the stateArray contains read information
     * @throws FileNotFoundException
     */
    @SuppressWarnings("resource")
    private StateArray readCovidFile(String fileName)
        throws FileNotFoundException {
        StateArray result = new StateArray();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String reader = scanner.nextLine();
            Scanner newScanner = new Scanner(reader);
            newScanner.useDelimiter(", *");
            int counter = 0;
            String[] infor = new String[11];
            while (newScanner.hasNext()) {
                infor[counter] = newScanner.next();
                counter++;
            }
            int[] number = new int[10];
            int num = 0;
            for (int i = 1; i < infor.length; i++) {
                if (!infor[i].equals("NA")) {
                    number[num] = Integer.valueOf(infor[i]);
                }
                else {
                    number[num] = -1;
                }
                num++;
            }

            Race white = new Race("Cases_White", number[0], number[5]);
            Race black = new Race("Cases_Black", number[1], number[6]);
            Race latinX = new Race("Cases_LatinX", number[2], number[7]);
            Race asian = new Race("Cases_Asian", number[3], number[8]);
            Race other = new Race("Cases_Other", number[4], number[9]);
            StateDLList list = new StateDLList(infor[0]);
            list.add(white);
            list.add(black);
            list.add(latinX);
            list.add(asian);
            list.add(other);
            result.add(list);
        }
        scanner.close();
        return result;
    }
}
