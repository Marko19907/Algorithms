package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sorting.Utilities.checkOrder;

public class BubbleSortTest {

    @Test
    @DisplayName("Test sorting with the Bubble Sort algo")
    public void testSorting() {
        // Arrange
        int[] array = new int[]{
                64, 34, 25, 12, 22, 11, 90
        };
        int[] sortedArray = null;

        // Act
        sortedArray = BubbleSort.bubbleSort(Arrays.copyOf(array, array.length));

        // Assert
        assertNotNull(sortedArray);
        assertTrue(checkOrder(sortedArray));
        assertEquals(sortedArray.length, array.length);
        assertEquals(Arrays.stream(array).distinct().count(),
                Arrays.stream(sortedArray).distinct().count()
        );
    }

    @Test
    @DisplayName("Test sorting with the optimized Bubble Sort algo")
    public void testSortingOptimizedAlgo() {
        // Arrange
        int[] array = new int[]{
                64, 34, 25, 12, 22, 11, 90
        };
        int[] sortedArray = null;

        // Act
        sortedArray = BubbleSort.bubbleSortOptimized(Arrays.copyOf(array, array.length));

        // Assert
        assertNotNull(sortedArray);
        assertTrue(checkOrder(sortedArray));
        assertEquals(sortedArray.length, array.length);
        assertEquals(Arrays.stream(array).distinct().count(),
                Arrays.stream(sortedArray).distinct().count()
        );
    }
}