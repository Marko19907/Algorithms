package dataStructures.binaryHeap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MinimumBinaryHeap {

    /**
     * The array backing the heap.
     */
    private final List<Integer> array;

    /**
     * A set used to duplicate detection.
     */
    private final Set<Integer> set;

    /**
     * Maximum size of the heap.
     */
    private final int maxSize;

    public MinimumBinaryHeap(int capacity) {
        this.maxSize = capacity;
        this.set = new HashSet<>();
        this.array = new ArrayList<>();
    }

    /**
     * Inserts the given data into the minimum binary heap, O(log(n)).
     * @param data The data to insert
     * @throws IllegalStateException If the heap is full
     * @throws IllegalArgumentException If the given data is a duplicate
     */
    public void insert(final int data) {
        // Guard conditions
        if (this.size() >= this.maxSize()) {
            throw new IllegalStateException("Can not insert into a full heap!");
        }
        if (this.set.contains(data)) {
            throw new IllegalArgumentException("Can not insert duplicates!");
        }

        this.array.add(data);

        final int indexOfLastElem = this.size() - 1;
        this.heapify(indexOfLastElem);

        this.set.add(data);
    }

    /**
     * Swaps the two given Nodes, O(1).
     * @param leftPos The position of the first Node to swap
     * @param rightPos The position of the first Node to swap
     * @throws IndexOutOfBoundsException If the leftPos or rightPos index is out of bounds
     */
    private void swap(int leftPos, int rightPos) {
        Objects.checkIndex(leftPos, this.size());
        Objects.checkIndex(rightPos, this.size());


        var elementLeft = this.array.get(leftPos);
        var elementRight = this.array.get(rightPos);

        this.array.set(leftPos, elementRight);
        this.array.set(rightPos, elementLeft);
    }

    /**
     * Heapify the node at the given position, O(log(n)).
     * @param position The given position
     */
    private void heapify(int position) {
        int parent = this.getParentIndex(position);

        while ((position > 0) && (this.less(position, parent))) {
            this.swap(parent, position);
            position = parent;

            parent = this.getParentIndex(position);
        }
    }

    /**
     * Returns true if the value of node at position i <= value of node at position j, O(1).
     * @throws IndexOutOfBoundsException If one of the positions is out of bounds
     */
    private boolean less(int i, int j) {
        Objects.checkIndex(i, this.size());
        Objects.checkIndex(j, this.size());

        var node1 = this.array.get(i);
        var node2 = this.array.get(j);
        return node1 <= node2;
    }

    // -----------
    // HELPERS
    // -----------

    /**
     * Prints the contents of the backing array to the console.
     */
    public void show() {
        System.out.println(this);
    }

    /**
     * Prints a tree representation of the heap to the console.
     */
    public void printHeap() {
        final List<Integer> list = new LinkedList<>(this.array);
        final int size = this.size();
        list.add(0, Integer.MIN_VALUE);

        int maxDepth = (int) (Math.log(size) / Math.log(2));  // log base 2 of n

        StringBuilder heapBuilder = new StringBuilder();
        for (int d = maxDepth; d >= 0; d--) {  // number of layers, we build this backwards
            int layerLength = (int) Math.pow(2, d);  // numbers per layer

            StringBuilder builder = new StringBuilder();  // line string builder
            for (int i = layerLength; i < (int) Math.pow(2, d + 1); i++) {
                // before spaces only on not-last layer
                if (d != maxDepth) {
                    builder.append(" ".repeat((int) Math.pow(2, maxDepth - d)));
                }
                // extra spaces for long lines
                int loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        builder.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }

                // add in the number
                if (i <= size) {
                    builder.append(String.format("%-2s", list.get(i)));  // add leading zeros
                }
                else {
                    builder.append("--");
                }

                builder.append(" ".repeat((int) Math.pow(2, maxDepth - d)));  // after spaces
                // extra spaces for long lines
                loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        builder.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }
            }
            heapBuilder.insert(0, builder + "\n");  // prepend line
        }
        System.out.println(heapBuilder);
    }

    /**
     * Returns the root node value
     */
    public int getRoot() {
        return this.array.get(0);
    }

    /**
     * Returns the parent value of the given key
     */
    private int getParent(int key) {
        return this.array.get(this.getParentIndex(key));
    }

    /**
     * Returns the parent index of the given key
     */
    private int getParentIndex(int key) {
        return (key - 1) / 2;
    }

    /**
     * Returns the left child of the given key
     */
    private int getLeftChild(int key) {
        return this.array.get(this.getLeftChildIndex(key));
    }

    /**
     * Returns the index of the left child of the given key
     */
    private int getLeftChildIndex(int key) {
        return (2 * key) + 1;
    }

    /**
     * Returns the right child of the given key
     */
    private int getRightChild(int key) {
        return this.array.get(this.getRightChildIndex(key));
    }

    /**
     * Returns the index of the right child of the given key
     */
    private int getRightChildIndex(int key) {
        return (2 * key) + 2;
    }

    /**
     * Returns the maximum size of the heap
     */
    public int maxSize() {
        return this.maxSize;
    }

    /**
     * Returns the size of the heap
     */
    public int size() {
        return this.array.size();
    }

    /**
     * Returns true if this heap is a minimum binary heap, O(n).
     * This recursive method is meant for testing purposes only.
     * @param k The Node at which to start the check, k=0 to start at the root
     */
    public boolean isMinHeap(int k) {
        final int heapSize = this.size();

        // Base case, outside the bounds
        if (k >= heapSize) {
            return true;
        }

        // The left and right child indexes
        final int leftChild = this.getLeftChildIndex(k);
        final int rightChild = this.getRightChildIndex(k);

        // Makes sure that the current node k is less than both of its children
        if (leftChild < heapSize && !this.less(k, leftChild)) {
            return false;
        }
        if (rightChild < heapSize && !this.less(k, rightChild)) {
            return false;
        }

        // Recurse on both children
        return this.isMinHeap(leftChild) && this.isMinHeap(rightChild);
    }

    /**
     * Returns the element at the given position
     */
    public int getElement(int position) {
        Objects.checkIndex(position, this.size());
        return this.array.get(position);
    }

    @Override
    public String toString() {
        return this.array.toString();
    }

    public static void main(String[] args) {
        var heap = new MinimumBinaryHeap(5);
        heap.insert(25);
        heap.insert(10);
        heap.show();
        heap.printHeap();

        System.out.println("Current size: " + heap.size());
        System.out.println(heap.isMinHeap(0));

        System.out.println("-------------");

        var heap2 = new MinimumBinaryHeap(7);
        heap2.insert(3);
        heap2.insert(6);
        heap2.insert(9);
        heap2.insert(5);
        heap2.insert(8);
        heap2.insert(1);
        heap2.printHeap();
        System.out.println(heap2.isMinHeap(0));

        System.out.println("-------------");

        var heap3 = new MinimumBinaryHeap(7);
        heap3.insert(1);
        heap3.insert(3);
        heap3.insert(6);
        heap3.insert(5);
        heap3.insert(9);
        heap3.insert(8);
        heap3.printHeap();
        System.out.println(heap3.isMinHeap(0));


        heap3.insert(1); // Will throw exception, duplicate element
    }
}
