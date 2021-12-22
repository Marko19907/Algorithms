package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sorting.Utilities.checkOrder;

public class SelectionSortTest {

    @Test
    @DisplayName("Tests selection sorting")
    public void testSorting() {
        // Arrange
        int[] array = new int[]{
                64, 34, 25, 12, 22, 11, 90
        };
        int[] sortedArray = null;

        // Act
        sortedArray = SelectionSort.selectionSort(Arrays.copyOf(array, array.length));

        // Assert
        assertNotNull(sortedArray);
        assertTrue(checkOrder(sortedArray));
        assertEquals(sortedArray.length, array.length);
        assertEquals(Arrays.stream(array).distinct().count(),
                Arrays.stream(sortedArray).distinct().count()
        );
    }

    @Test
    @DisplayName("Tests selection sorting with a longer list")
    public void testSortingLong() {
        // Arrange
        int[] array = new int[]{
                47, 44, 80, 65, 84, 41, 5, 54, 33, 73, 60, 14, 53, 23, 42
        };
        int[] sortedArray = null;

        // Act
        sortedArray = SelectionSort.selectionSort(Arrays.copyOf(array, array.length));

        // Assert
        assertNotNull(sortedArray);
        assertTrue(checkOrder(sortedArray));
        assertEquals(sortedArray.length, array.length);
        assertEquals(Arrays.stream(array).distinct().count(),
                Arrays.stream(sortedArray).distinct().count()
        );
    }

}