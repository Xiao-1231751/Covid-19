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
 * It is a class to store the information of the race
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.20.2022
 */
public class StateArray {

    private StateDLList[] array;
    private int size;

    /**
     * Create a constructor to the StateArray Class
     */
    public StateArray() {
        array = new StateDLList[6];
        size = 0;
    }


    /**
     * Create a method to check if the array is full or not
     * 
     * @return return true if it is full and return false if it is not full
     */
    public boolean isFull() {
        return size == 6;
    }


    /**
     * Create a method to Check if the array if empty or not
     * 
     * @return return true if the array is empty, and return false if the array
     *         is not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Create a method to get the array
     * 
     * @return a array contains information of the races
     */
    public StateDLList[] getArray() {
        return this.array;
    }


    /**
     * Create a method to get an element by using index
     * 
     * @param index
     *            the location of the element
     * @return the element in a specific index
     */
    public StateDLList getElement(int index) {
        if (index < 0 || index > 5) {
            throw new IndexOutOfBoundsException();
        }
        else {
            return array[index];
        }
    }


    /**
     * Create a method to add a element in the array
     * 
     * @param newOne
     *            the stateDLList will be added
     * @return return true if add successful, and return false if didn't add
     *         successful
     */
    public boolean add(StateDLList newOne) {
        if (!this.isFull()) {
            array[size] = newOne;
            this.size++;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Create a method to print the information from the array
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                builder.append(array[i].getName());
                builder.append("\n");
                array[i].sortName();
                builder.append(array[i].toString());
                builder.append("====");
                builder.append("\n");
                array[i].sort();
                builder.append(array[i].toString());
                builder.append("====");
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
