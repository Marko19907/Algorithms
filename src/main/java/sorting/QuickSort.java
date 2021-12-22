package sorting;

import java.util.Arrays;

import static sorting.Utilities.checkOrder;
import static sorting.Utilities.printArray;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }
        if (array.length <= 1) {
            // 0 or 1 elements => nothing to do
            return array;
        }

        recurse(array, 0, array.length - 1);

        return array;
    }

    private static void recurse(int[] array, int start, int stop) {
        if (start < stop) {
            // Partitioning index
            int index = partition(array, start, stop);

            recurse(array, start, index - 1);  // Before index
            recurse(array, index + 1, stop);   // After index
        }
    }

    private static int partition(int[] array, int start, int stop) {
        int pivot = array[stop];
        int smallestIndex = (start - 1);

        for (int index = start; index <= stop - 1; index++) {
            // If current element is smaller than the pivot
            if (array[index] < pivot) {
                // Increment index of smaller element
                smallestIndex++;
                swap(array, smallestIndex, index);
            }
        }
        swap(array, smallestIndex + 1, stop);
        return (smallestIndex + 1);
    }

    /**
     * Swaps the left and right indexes in the given array
     */
    private static void swap(int[] array, int left, int right) {
        final int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // ------------------------------------
    // In-place partitioning version
    // ------------------------------------

    public static int[] quickSortInPlace(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }
        if (array.length <= 1) {
            // 0 or 1 elements => nothing to do
            return array;
        }

        while (!checkOrder(array)) {
            partitionInPlace(array, 0, array.length);
        }

        return array;
    }

    private static int partitionInPlace(int[] array, int start, int stop) {
        final int pivot = midPoint(start, stop);
        swap(array, start, pivot);
        int left = start + 1;
        int right = stop - 1;

        while (left <= right) {
            if (array[left] <= array[start]) {
                left += 1;
            }
            else {
                swap(array, left, right);
                right -= 1;
            }
        }
        swap(array, start, left - 1);
        return left - 1;
    }

    /**
     * Finds the mid-point between the two given numbers.
     */
    private static int midPoint(int min, int max) {
        return Math.floorDiv((max + min), 2);
    }

    public static void main(String[] args) {
        int[] array = new int[] {
                64, 25, 12, 22, 11
        };

        int[] arraySorted1 = quickSort(Arrays.copyOf(array, array.length));
        printArray(arraySorted1);

        System.out.println("Testing quick sort with copy . . .");

        int[] arraySorted2 = quickSortInPlace(Arrays.copyOf(array, array.length));
        printArray(arraySorted2);
    }
}
