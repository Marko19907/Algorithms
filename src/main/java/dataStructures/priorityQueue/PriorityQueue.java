package dataStructures.priorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PriorityQueue<V> {
    private final List<Entry<Integer, V>> array;
    private final int maxCapacity;

    public PriorityQueue(int capacity) {
        this.array = new LinkedList<>();
        this.maxCapacity = capacity;
    }

    public void add(V element, int priority) {
        // Guard conditions
        if (element == null) {
            throw new IllegalArgumentException("The given element can not be null!");
        }
        if (priority <= 0) {
            throw new IllegalArgumentException("The given priority can not be 0 or negative!");
        }
        if (this.size() + 1 > this.maxCapacity) {
            throw new IllegalStateException("The queue is full, can not insert . . .");
        }

        this.array.add(new Entry<>(priority, element));
    }

    /**
     * Returns true if this queue contains no elements.
     * @return True if this queue contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /**
     * Returns the size of the queue.
     */
    public int size() {
        return this.array.size();
    }

    /**
     * Returns (but does not remove) an element with the minimal key, O(n) operation.
     */
    public V min() {
        // Guard condition
        if (this.isEmpty()) {
            return null;
        }

        int smallestIndex = this.findMinIndex();
        return this.array.get(smallestIndex).getValue();
    }

    /**
     * Removes and returns the element with the minimal key,
     * O(2*n) -> O(n) operation.
     */
    public V removeMin() {
        // Guard condition
        if (this.isEmpty()) {
            return null;
        }

        int smallestIndex = this.findMinIndex();
        return this.array.remove(smallestIndex).getValue();
    }

    /**
     * Returns the position of the element with the smallest key, O(n) operation.
     * @return The position of the element with the smallest key
     */
    private int findMinIndex() {
        // Guard condition, should never occur
        if (this.isEmpty()) {
            throw new IllegalStateException("There is no minimum in an empty queue!");
        }

        final AtomicInteger minimum = new AtomicInteger(Integer.MAX_VALUE);
        IntStream.range(0, this.size())
                .forEachOrdered(index -> {
                    if (this.array.get(index).getKey() < minimum.get()) {
                        minimum.set(index);
                    }
                });
        return minimum.get();
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);

        priorityQueue.add("test1", 1);
        priorityQueue.add("test2", 2);
        priorityQueue.add("test3", 3);
        System.out.println("---");

        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.min());

        System.out.println(priorityQueue.removeMin());
        System.out.println(priorityQueue.size());
    }
}
