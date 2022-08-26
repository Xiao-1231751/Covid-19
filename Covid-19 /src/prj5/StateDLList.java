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
 * This represents a node in a doubly linked list. This node stores data, a
 * pointer to the node before it in the list, and a pointer to the node
 * after it in the list
 *
 * 
 * @author Tejas Navada
 * @author Huhua Xiao(xiaohuhua2019)
 * 
 * @version 4/20/2022
 */
public class StateDLList {

    /**
     * Create a inner node class
     * 
     * @author xiaohuhua
     *
     * @param <Race>
     */
    @SuppressWarnings("hiding")
    private static class Node<Race> {
        private Node<Race> next;
        private Node<Race> previous;
        private Race data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(Race d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<Race> n) {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<Race> n) {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<Race> next() {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<Race> previous() {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public Race getData() {
            return data;
        }
    }

    /**
     * The name of the state
     */
    private String name;
    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<Race> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<Race> tail;

    /**
     * Create a new DLList object.
     * 
     * @param name
     *            the name of the SatateDLList
     */
    public StateDLList(String name) {
        this.name = name;
        head = new StateDLList.Node<Race>(null);
        tail = new StateDLList.Node<Race>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Get the name of the state
     * 
     * @return the name of the StateDLList
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get the head of the state
     * 
     * @return the head of the node
     */
    public Node<Race> getHead() {
        return head;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        head = new StateDLList.Node<Race>(null);
        tail = new StateDLList.Node<Race>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(Race obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public Race get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(Race newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, Race obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }
        Node<Race> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }
        Node<Race> addition = new Node<Race>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<Race> getNodeAtIndex(int index) {
        Node<Race> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(Race obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<Race> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @return true if successful
     */
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        Node<Race> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;

    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */
    public boolean remove(Race obj) {
        if (obj != null) {
            Node<Race> current = head.next();
            while (!current.equals(tail)) {
                if (current.getData().equals(obj)) {
                    current.previous().setNext(current.next());
                    current.next().setPrevious(current.previous());
                    size--;
                    return true;
                }
                current = current.next();
            }
        }
        return false;

    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            Node<Race> currNode = head.next();
            while (currNode != tail) {
                builder.append(currNode.getData().toString());
                builder.append("\n");
                currNode = currNode.next();
            }
        }
        return builder.toString();
    }


    /**
     * Create a method to sort the node by CFR from larger to small
     */
    public void sort() {
        if (size != 0) {
            Node<Race> secondPart = head.next.next;
            Node<Race> firstPart = head.next;
            firstPart.setNext(null);
            while (secondPart != tail) {
                Node<Race> nodeInsert = secondPart;
                secondPart = secondPart.next;
                this.insertIntoSorted(nodeInsert);
            }
            while (firstPart.next != null) {
                firstPart = firstPart.next;
            }
            tail = firstPart.next;
        }
    }


    /**
     * Create a helper method to sort the node by CFR from larger to small
     * 
     * @param nodeToInsert
     *            the node will be used to sort
     */
    public void insertIntoSorted(Node<Race> nodeToInsert) {
        Race answer = nodeToInsert.data;
        Node<Race> currentNode = head.next;
        Node<Race> previousNode = null;
        while ((currentNode != null) && (answer.compareTo(
            currentNode.data) < 0)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(head.next);
            head.next = nodeToInsert;
        }
    }


    /**
     * Create a method to sort the node by Alpha(Name)
     */
    public void sortName() {
        if (size != 0) {
            Node<Race> secondPart = head.next.next;
            Node<Race> firstPart = head.next;
            firstPart.setNext(null);
            while (secondPart != tail) {
                Node<Race> nodeInsert = secondPart;
                secondPart = secondPart.next;
                this.insertIntoSortedName(nodeInsert);

            }
            while (firstPart.next != null) {
                firstPart = firstPart.next;
            }
            tail = firstPart.next;
        }
    }


    /**
     * Create a helper method to sort the node by Alpha(Name)
     * 
     * @param nodeToInsert
     *            the node will be used to sort
     */
    public void insertIntoSortedName(Node<Race> nodeToInsert) {
        Race answer = nodeToInsert.data;
        Node<Race> currentNode = head.next;
        Node<Race> previousNode = null;
        while ((currentNode != null) && (answer.getName().compareTo(
            currentNode.data.getName()) > 0)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(head.next);
            head.next = nodeToInsert;
        }
    }


    /**
     * Create a method to create the iterator
     * 
     * @return the iterator created
     */
    public Iterator<Race> iterator() {
        return new StateDLListIterator<Race>();
    }

    /**
     * Create a inner iterator class
     * 
     * @author xiaohuhua
     *
     * @param <A>
     */
    @SuppressWarnings("hiding")
    private class StateDLListIterator<A> implements Iterator<Race> {
        private Node<Race> next;
        @SuppressWarnings("unused")
        private boolean calledNext;

        /**
         * Creates a new DLListIterator
         */

        public StateDLListIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next.next() != tail;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public Race next() {

            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            next = next.next;
            Race data = next.data;
            calledNext = true;
            return data;
        }

    }

}
