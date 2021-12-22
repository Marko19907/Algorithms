package dataStructures.singlyLinkedList;

/**
 * Class Node represents a single Node in the custom linked list.
 * @param <E> The type of elements in this list
 *
 * @author Marko
 * @version 15-09-2021
 */
public class Node<E> {
    /**
     * The Node's data.
     */
    private E data = null;

    /**
     * The next connected Node, null if no link to another Node.
     */
    private Node<E> next = null;

    /**
     * Constructor for Node objects with data.
     * @param data The data that the Node will hold
     */
    public Node (E data) {
        this.data = data;
    }

    /**
     * Sets the given Node as the next Node.
     * @param next The Node to set as the next Node
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Returns the Node's data.
     * @return The Node's data
     */
    public E getData() {
        return this.data;
    }

    /**
     * Returns the next Node.
     * @return The next Node
     */
    public Node<E> getNextNode() {
        return this.next;
    }
}
