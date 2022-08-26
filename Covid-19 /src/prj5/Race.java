package prj5;

import java.text.DecimalFormat;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)
// -- Daniel Jinsoo Bae (dbae59)
// -- Tejas Navada (tejasnavada)

/**
 * The class about the race information
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class Race implements Comparable<Race> {
    private String name;
    private int cases;
    private int deaths;
    private String cfr;

    /**
     * Create a constructor of the Race class
     * 
     * @param name
     *            The name of the race
     * @param casesNumber
     *            The cases number of the race
     * @param deathsNumber
     *            The deaths number of the race
     */
    public Race(String name, int casesNumber, int deathsNumber) {
        this.name = name;
        this.cases = casesNumber;
        this.deaths = deathsNumber;
    }


    /**
     * Create a method to get the name of the race
     * 
     * @return the name of the race
     */
    public String getName() {
        return this.name;
    }


    /**
     * Create a method to get the cases of Covid in a specific race
     * 
     * @return the all vocid-19 cases
     */
    public int getCases() {
        return this.cases;
    }


    /**
     * Create a method to get the deaths of Covid
     * 
     * @return the deaths of the covid-19
     */
    public int getDeaths() {
        return this.deaths;
    }


    /**
     * Create a method to calculator of the CFR
     * 
     * @return return the cfr as string
     */
    public String calculatorCFR() {
        DecimalFormat dc = new DecimalFormat("#.#");
        if (this.cases == -1 || this.deaths == -1) {
            cfr = "-1";
        }
        else {
            cfr = dc.format((Double.valueOf(deaths) / Double.valueOf(cases))
                * 100);
        }
        return cfr;
    }

    /**
     * Create a method to print the information of race
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.cases == -1 || this.deaths == -1) {
            builder.append(this.name + ": " + this.cases + " cases, -1% CFR");
        }
        else {
            builder.append(this.name + ": " + this.cases + " cases, " + this
                .calculatorCFR() + "% CFR");
        }
        return builder.toString();

    }

    /**
     * Create a method to compare CFR
     * Return positive if firstCFR bigger than secondCFR
     * Return negative if fitstCFR smaller than secondCFR
     * Return 0 if they are equal
     * 
     * @param newOne
     *            the new race will be used to compare
     */
    @Override
    public int compareTo(Race newOne) {
        double firstCFR = Double.valueOf(this.calculatorCFR());
        double secondCFR = Double.valueOf(newOne.calculatorCFR());
        if (firstCFR > secondCFR) {
            return 1;
        }
        else if (firstCFR < secondCFR) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Create a method to get the shorter name of the race
     * 
     * @return the shorter name of the race
     */
    public String getRealName() {
        if (this.name.contains("Black")) {
            return "black";
        }
        else if (this.name.contains("White")) {
            return "white";
        }
        else if (this.name.contains("Asian")) {
            return "asian";
        }
        else if (this.name.contains("Other")) {
            return "other";
        }
        else {
            return "latinx";
        }
    }
}
