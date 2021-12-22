package sorting;

import java.util.Arrays;

import static sorting.Utilities.printArray;

public class SelectionSort {

    /**
     * Sorts the given array with the selection sort algo
     * @param array The array to sort, not null
     * @return The sorted array
     * @throws IllegalArgumentException If the given array is null
     */
    public static int[] selectionSort(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }
        if (array.length <= 1) {
            // 0 or 1 elements => nothing to do
            return array;
        }

        int left = 0;
        final int right = array.length - 1;

        while (left < right) {
            int minimum = findMinimumLocation(array, left);
            if (array[minimum] < array[left]) {
                swap(array, left, minimum);
            }
            left++;
        }
        return array;
    }

    /**
     * Returns the location (index) of the minimum element in
     * the given array from the given starting point.
     * @param array The array to find the minimum element index in, not null
     * @param start The start position, the search includes and begins from this element
     * @return The location (index) of the minimum element in the given array
     * @throws IllegalStateException If the given array is null
     */
    private static int findMinimumLocation(int[] array, int start) {
        if (array == null) {
            throw new IllegalStateException("The array can not be null!");
        }

        int index = start;
        int minimum = start;
        while (index < array.length) {
            if (array[index] < array[minimum]) {
                minimum = index;
            }
            index++;
        }
        return minimum;
    }

    /**
     * Swaps the left and right indexes in the given array
     */
    private static void swap(int[] array, int left, int right) {
        final int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {
                64, 25, 12, 22, 11
        };

        int[] arraySorted = selectionSort(Arrays.copyOf(array, array.length));
        printArray(arraySorted);
    }
}
