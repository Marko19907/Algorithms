package dataStructures.singlyLinkedList;

import java.util.Objects;

/**
 * The class represents a custom-built singly linked list.
 * @param <E> The type of elements in this list
 *
 * @author Marko
 * @version 15-09-2021
 */
public class SinglyLinkedList<E> {

    /**
     * The first Node.
     */
    private Node<E> head;

    /**
     * A default no-arg constructor for SinglyLinkedList objects.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Adds the given data to the end of the list. Equivalent to addLast().
     * @param data The data to add
     */
    public void add(E data) {
        if (this.isEmpty()) {
            this.head = new Node<>(data);
        }
        else {
            this.findLast().setNext(new Node<>(data));
        }
    }

    /**
     * Inserts the given data at the given position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param position The position to insert the data at
     * @param data The data to insert
     * @throws IndexOutOfBoundsException If the given position is out of bounds
     */
    public void insert(int position, E data) {
        // Guard condition
        Objects.checkIndex(position, this.size());

        if (position == 0) {
            this.addFirst(data);
        }
        else {
            Node<E> toInsert = new Node<>(data);
            Node<E> previousNode = this.get(position - 1);
            Node<E> currentNode = previousNode.getNextNode();
            Node<E> nextNode = currentNode.getNextNode();

            previousNode.setNext(toInsert);
            toInsert.setNext(currentNode);
            currentNode.setNext(nextNode);
        }
    }

    /**
     * Replaces the element at the specified position in this list with the given data.
     * @param position The position at which to replace the element
     * @param data The data to replace the element with
     */
    public void set(int position, E data) {
        // Guard condition
        Objects.checkIndex(position, this.size());

        Node<E> toInsert = new Node<>(data);

        if (position == 0) {
            Node<E> nextNode = this.head.getNextNode();
            this.head = toInsert;
            this.head.setNext(nextNode);
        }
        else {
            Node<E> previousNode = this.get(position - 1);
            Node<E> toReplace = previousNode.getNextNode();
            previousNode.setNext(toInsert);
            toInsert.setNext(toReplace.getNextNode());
        }
    }

    /**
     * Adds the given data to the front of the list.
     * @param data The data to add to the front of the list
     */
    public void addFirst(E data) {
        Node<E> tmp = new Node<>(data);
        tmp.setNext(this.head);
        this.head = tmp;
    }

    /**
     * Appends the specified element to the end of this list. Equivalent to add.
     * @param data The to add
     */
    public void addLast(E data) {
        this.add(data);
    }

    /**
     * Finds the Node at the given position.
     * @param position The position of the Node to find
     * @return The found Node
     * @throws IndexOutOfBoundsException If the given position is out of bounds
     */
    public Node<E> get(int position) {
        // Guard condition
        Objects.checkIndex(position, this.size());

        Node<E> toReturn = null;
        Node<E> currentNode = this.head;
        boolean running = true;
        int index = 0;

        while (currentNode != null && running) {
            if (index == position) {
                toReturn = currentNode;
                running = false;
            }

            currentNode = currentNode.getNextNode();
            index++;
        }

        return toReturn;
    }

    /**
     * Returns the last Node of the list.
     * @return The last Node of the list
     */
    private Node<E> findLast() {
        return this.get(this.size() - 1);
    }

    /**
     * Returns the size of the linked list.
     * @return The size of the linked list
     */
    public int size() {
        Node<E> current = this.head;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.getNextNode();
        }

        return counter;
    }

    /**
     * Prints the content of the list to the console
     */
    public void printAll() {
        Node<E> current = this.head;

        while (current != null) {
            System.out.println(current.getData());
            current = current.getNextNode();
        }
    }

    /**
     * Clears the linked list.
     */
    public void clear() {
        this.head = null;
    }

    /**
     * Returns true if this list contains no elements.
     * @return True if this list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(123);
        list.add(1);

        list.printAll();
        System.out.println(list.size());

        list.get(1);

        list.clear();

        System.out.println("----------");

        list = new SinglyLinkedList<>();

        list.add(0); list.add(1); list.add(2); list.add(3); list.add(4);

        list.printAll();

        list.set(4, 123);

        list.printAll();

        list.add(5);

        list.set(4, 400);

        list.printAll();
    }
}
