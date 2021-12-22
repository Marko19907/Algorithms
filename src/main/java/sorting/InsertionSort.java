package sorting;

import java.util.Arrays;

import static sorting.Utilities.printArray;

public class InsertionSort {

    /**
     * Sorts the given array with the insertion sort algo
     * @param array The array to sort, not null
     * @return The sorted array
     * @throws IllegalArgumentException If the given array is null
     */
    public static int[] insertionSort(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }
        if (array.length <= 1) {
            // 0 or 1 elements => nothing to do
            return array;
        }

        int index = 1;
        while (index < array.length) {
            int value = array[index];
            int previous = index - 1;

            if (array[previous] > value) {
                shift(array, value, previous);
            }

            index++;
        }

        return array;
    }

    /**
     * Downshift the value in the given array by the given target(steps).
     */
    private static void shift(final int[] array, final int value, int target) {
        while (target >= 0 && array[target] > value) {
            array[target + 1] = array[target];
            target--;
        }
        array[target + 1] = value;
    }

    public static void main(String[] args) {
        int[] array = new int[]{
                64, 25, 12, 22, 11
        };

        int[] arraySorted = insertionSort(Arrays.copyOf(array, array.length));
        printArray(arraySorted);
    }
}
