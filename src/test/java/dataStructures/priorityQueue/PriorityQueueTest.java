package dataStructures.priorityQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityQueueTest {

    @Test
    @DisplayName("Tests the constructor")
    public void testConstructor() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);

        // Act

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
    }

    @Test
    @DisplayName("Tests adding elements")
    public void testAddingElements() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        final int priority = 1;
        final String data = "test1";

        // Act
        priorityQueue.add(data, priority);

        // Assert
        assertFalse(priorityQueue.isEmpty());
        assertEquals(1, priorityQueue.size());
        assertTrue(priorityQueue.min().equals(data));
    }

    @Test
    @DisplayName("Tests adding null")
    public void testAddingNull() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        final int priority = 1;
        final String data = null;
        boolean exceptionThrown = false;

        // Act
        try {
            priorityQueue.add(data, priority);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests adding a negative key")
    public void testAddingNegativeKey() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        final int priority = -10;
        final String data = "test1";
        boolean exceptionThrown = false;

        // Act
        try {
            priorityQueue.add(data, priority);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests adding a 0 key")
    public void testAddingZeroKey() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        final int priority = 0;
        final String data = "test1";
        boolean exceptionThrown = false;

        // Act
        try {
            priorityQueue.add(data, priority);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests adding to a full queue")
    public void testAddingToFullQueue() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(1);
        final int priority = 42;
        final String data = "test2";
        boolean exceptionThrown = false;
        priorityQueue.add("test1", 31);

        // Act
        try {
            priorityQueue.add(data, priority);
        }
        catch (IllegalStateException e) {
            exceptionThrown = true;
        }

        // Assert
        assertFalse(priorityQueue.isEmpty());
        assertEquals(1, priorityQueue.size());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests removing elements")
    public void testRemovingElements() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        final int priority = 1;
        final String data = "test1";
        priorityQueue.add(data, priority);

        // Act
        String returnedData = priorityQueue.removeMin();

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertNotNull(returnedData);
        assertEquals(data, returnedData);
    }

    @Test
    @DisplayName("Tests removing elements on an empty queue")
    public void testRemovingElementsOnEmptyQueue() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);

        // Act
        String returnedData = priorityQueue.removeMin();

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertNull(returnedData);
    }

    @Test
    @DisplayName("Tests 'peeking' on an empty queue")
    public void testPeekOnEmptyQueue() {
        // Arrange
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);

        // Act
        String returnedData = priorityQueue.min();

        // Assert
        assertTrue(priorityQueue.isEmpty());
        assertEquals(0, priorityQueue.size());
        assertNull(returnedData);
    }
}