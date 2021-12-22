package dataStructures.binaryHeap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinimumBinaryHeapTest {

    @Test
    @DisplayName("Tests the constructor")
    public void testConstructor() {
        // Arrange
        var heap = new MinimumBinaryHeap(7);

        // Act
        heap.insert(3);

        // Assert
        assertTrue(heap.isMinHeap(0));
        assertEquals(3, heap.getElement(0));
        assertEquals(1, heap.size());
        assertEquals(7, heap.maxSize());
    }

    @Test
    @DisplayName("Tests adding an element")
    public void testAddingElement() {
        // Arrange
        var heap = new MinimumBinaryHeap(7);

        // Act
        heap.insert(3);
        heap.insert(6);
        heap.insert(9);
        heap.insert(5);
        heap.insert(8);
        heap.insert(1);

        // Assert
        assertTrue(heap.isMinHeap(0));
        assertEquals(1, heap.getRoot());
        assertEquals(6, heap.size());
        assertEquals(7, heap.maxSize());
    }

    @Test
    @DisplayName("Tests adding an element to a full heap")
    public void testAddingOverCapacity() {
        // Arrange
        var heap = new MinimumBinaryHeap(2);
        boolean exceptionThrown = false;

        // Act
        heap.insert(6);
        heap.insert(3);
        try {
            heap.insert(23);
        }
        catch (IllegalStateException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(heap.isMinHeap(0));
        assertTrue(exceptionThrown);
        assertEquals(2, heap.size());
    }

    @Test
    @DisplayName("Tests the positions of the elements")
    public void testPositions() {
        // Arrange
        var heap = new MinimumBinaryHeap(7);

        // Act
        heap.insert(6);
        heap.insert(5);
        heap.insert(8);
        heap.insert(3);
        heap.insert(1);
        heap.insert(9);

        // Assert
        assertTrue(heap.isMinHeap(0));
        assertEquals(1, heap.getElement(0));
        assertEquals(6, heap.size());
        assertEquals(7, heap.maxSize());
    }

    @Test
    @DisplayName("Tests adding a duplicate")
    public void testAddingDuplicates() {
        // Arrange
        var heap = new MinimumBinaryHeap(5);
        boolean exceptionThrown = false;

        // Act
        heap.insert(6);
        heap.insert(3);
        try {
            heap.insert(3);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(heap.isMinHeap(0));
        assertTrue(exceptionThrown);
        assertEquals(3, heap.getRoot());
        assertEquals(2, heap.size());
    }
}