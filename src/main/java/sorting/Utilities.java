package sorting;

import java.util.Arrays;

/**
 * A utility class for all sorting algorithms.
 */
public final class Utilities {

    private Utilities() {
        // Empty constructor
    }

    /**
     * Returns true if the given array is sorted.
     * @param array The array to check, not null
     * @return True if the given array is sorted, false otherwise
     * @throws IllegalArgumentException If the given array is null
     */
    public static boolean checkOrder(int[] array) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException("The array can not be null!");
        }

        boolean result = true;
        int index = 0;
        int temp = 0;
        while (temp < array.length - 1) {
            temp = index;
            temp++;
            if (array[index] > array[temp]) {
                result = false;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Prints out the given array to the console.
     * @param array The array to print, not null
     */
    public static void printArray(int[] array) {
        if (array != null) {
            Arrays.stream(array).forEachOrdered(System.out::println);
        }
    }
}
