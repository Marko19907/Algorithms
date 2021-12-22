package sorting;

import static sorting.Utilities.checkOrder;
import static sorting.Utilities.printArray;

public class BubbleSort {

    /**
     * The bubble sort algo.
     * @param array The array to sort, not null
     * @return The sorted array
     * @throws IllegalArgumentException If the given array is null
     */
    public static int[] bubbleSort(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }
        if (array.length <= 1) {
            // 0 or 1 elements => nothing to do
            return array;
        }

        int left = 0;
        int right = 1;
        boolean sorting = true;
        while (sorting) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }

            // increment pointers
            left++;
            right++;
            if (right >= array.length) {
                sorting = !checkOrder(array);

                left = 0;
                right = 1;
            }
        }

        return array;
    }

    /**
     * An optimized version of the bubble sort algo.
     * @param array The array to sort, not null
     * @return The sorted array
     * @throws IllegalArgumentException If the given array is null
     */
    public static int[] bubbleSortOptimized(int[] array) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array to sort can not be null!");
        }

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int index = 0, temp = 0; temp < array.length - 1; index++) {
                temp = index;
                temp++;
                if (array[index] > array[temp]) {
                    swap(array, index, temp);
                    swapped = true;
                }
            }
        }


        return array;
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
                5, 4, 3, 1
        };

        int[] arraySorted = bubbleSort(array);
        printArray(arraySorted);

        int[] array3 = new int[] {
                5, 4, 3, 1
        };

        System.out.println(checkOrder(array));
        System.out.println(checkOrder(arraySorted));
        System.out.println(checkOrder(array3));

        int[] arraySortedOptimized = bubbleSortOptimized(array3);
        printArray(arraySortedOptimized);
        System.out.println(checkOrder(array3));
    }
}
