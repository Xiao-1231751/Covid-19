package prj5;

import java.awt.Color;
import java.util.Iterator;
import cs2.Shape;
import cs2.TextShape;
import cs2.Button;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * The window class to show the information as a graph
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class GUIWindow {

    private Window window;
    private StateArray stateArray;
    private Shape shape;
    private TextShape cfrText;
    private int times;
    private StateDLList[] array;

    /**
     * The constructor of the window
     * 
     * @param state
     */
    public GUIWindow(StateArray state) {
        window = new Window();
        stateArray = state;
        array = stateArray.getArray();

        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        Button sortByCFR = new Button("Sort by CFR");
        sortByCFR.onClick(this, "sortByCFR");

        Button sortByAlpha = new Button("Sort by Alpha");
        sortByAlpha.onClick(this, "sortByAlpha");

        Button representDC = new Button("Represent DC");
        representDC.onClick(this, "representDC");

        Button representMD = new Button("Represent MD");
        representMD.onClick(this, "representMD");

        Button representTN = new Button("Represent TN");
        representTN.onClick(this, "representTN");

        Button representNC = new Button("Represent NC");
        representNC.onClick(this, "representNC");

        Button representGA = new Button("Represent GA");
        representGA.onClick(this, "representGA");

        Button representVA = new Button("Represent VA");
        representVA.onClick(this, "representVA");

        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);

        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);

    }


    /**
     * Create a method to quit the window
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Create a method to connect the sort() method and button
     * 
     * @param button
     */
    public void sortByCFR(Button button) {
        array[times].sort();
        this.uploadInfor(array[times]);
    }


    /**
     * Create a method to connect the sortName() method and button
     * 
     * @param button
     */
    public void sortByAlpha(Button button) {
        array[times].sortName();
        this.uploadInfor(array[times]);
    }


    /**
     * Create a method to upload new information every time when click button
     * 
     * @param button
     */
    public void uploadInfor(StateDLList newArray) {
        window.removeAllShapes();
        Iterator<Race> iterator = newArray.iterator();
        int counter = 5;
        while (iterator.hasNext()) {
            int height = window.getGraphPanelHeight();
            int width = window.getGraphPanelWidth();
            Race newOne = iterator.next();
            String name = newOne.getRealName();
            double cfrNumber = Double.valueOf(newOne.calculatorCFR());
            int number = (int)Math.round(cfrNumber) + 1;
            shape = new Shape(width - (counter * 150), height - 80 - (20
                * number), 20, 20 * number, Color.BLUE);
            TextShape textBlack = new TextShape(width - (counter * 150) - name
                .length() * 2, height - 80, name, Color.BLACK);
            if (cfrNumber == -1.0) {
                cfrText = new TextShape(width - (counter * 150), height - 100,
                    "NA", Color.BLACK);
            }
            else {
                cfrText = new TextShape(width - (counter * 150) - 8, height
                    - 60, cfrNumber + "%", Color.BLACK);
            }
            TextShape title = new TextShape((width / 2) - 120, 10, newArray
                .getName() + " Case Fatality Ratios by Race", Color.BLACK);

            window.addShape(shape);
            window.addShape(textBlack);
            window.addShape(cfrText);
            window.addShape(title);
            counter--;
        }

    }


    /**
     * Create a method to show the information of DC when clicked button
     * 
     * @param button
     */
    public void representDC(Button button) {
        array[0].sort();
        this.uploadInfor(array[0]);
        times = 0;
    }


    /**
     * Create a method to show the information of GA when clicked button
     * 
     * @param button
     */
    public void representGA(Button button) {

        array[1].sort();
        this.uploadInfor(array[1]);
        times = 1;
    }


    /**
     * Create a method to show the information of MD when clicked button
     * 
     * @param button
     */
    public void representMD(Button button) {

        array[2].sort();
        this.uploadInfor(array[2]);
        times = 2;
    }


    /**
     * Create a method to show the information of NC when clicked button
     * 
     * @param button
     */
    public void representNC(Button button) {
        array[3].sort();
        this.uploadInfor(array[3]);
        times = 3;
    }


    /**
     * Create a method to show the information of TN when clicked button
     * 
     * @param button
     */
    public void representTN(Button button) {
        array[4].sort();
        this.uploadInfor(array[4]);
        times = 4;
    }


    /**
     * Create a method to show the information of VA when clicked button
     * 
     * @param button
     */
    public void representVA(Button button) {

        array[5].sort();
        this.uploadInfor(array[5]);
        times = 5;
    }
}
