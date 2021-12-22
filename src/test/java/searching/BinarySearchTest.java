package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static searching.BinarySearch.binarySearch;
import static searching.BinarySearch.binarySearchRecursive;

public class BinarySearchTest {

    public static final int[] ARRAY_SMALL = new int[]{
            1, 3, 5
    };
    public static final int[] ARRAY_LARGE = new int[]{
            2, 3, 4, 10, 40, 45, 60, 100, 321, 555, 1329, 4325
    };

    @Test
    @DisplayName("Test binary search on a small array")
    public void testBinarySearchSmallArray() {
        assertEquals(1, binarySearch(ARRAY_SMALL, 1));
        assertEquals(3, binarySearch(ARRAY_SMALL, 3));
        assertEquals(5, binarySearch(ARRAY_SMALL, 5));
        assertEquals(-1, binarySearch(ARRAY_SMALL, 555));
    }

    @Test
    @DisplayName("Test binary search on a large array")
    public void testBinarySearchLargeArray() {
        assertEquals(4325, binarySearch(ARRAY_LARGE, 4325));
        assertEquals(4, binarySearch(ARRAY_LARGE, 4));
        assertEquals(321, binarySearch(ARRAY_LARGE, 321));
        assertEquals(-1, binarySearch(ARRAY_LARGE, 51524));
    }

    @Test
    @DisplayName("Test binary search on a small array using recursion")
    public void testBinarySearchSmallArrayRecursive() {
        assertEquals(1, binarySearchRecursive(ARRAY_SMALL, 1));
        assertEquals(3, binarySearchRecursive(ARRAY_SMALL, 3));
        assertEquals(5, binarySearchRecursive(ARRAY_SMALL, 5));
        assertEquals(-1, binarySearchRecursive(ARRAY_SMALL, 555));
    }

    @Test
    @DisplayName("Test binary search on a large array using recursion")
    public void testBinarySearchLargeArrayRecursive() {
        assertEquals(4325, binarySearchRecursive(ARRAY_LARGE, 4325));
        assertEquals(4, binarySearchRecursive(ARRAY_LARGE, 4));
        assertEquals(321, binarySearchRecursive(ARRAY_LARGE, 321));
        assertEquals(-1, binarySearchRecursive(ARRAY_LARGE, 51524));
    }
}
