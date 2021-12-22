package other.miniMaxSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MiniMaxSum {

    /**
     * Given five positive integers, find the minimum and maximum values
     * that can be calculated by summing exactly four of the five integers.
     *
     * Case #1
     * Sample Input:  [1, 2, 3, 4, 5]
     * Sample Output: [10, 14]
     *
     * Case #2
     * Sample Input:  [7, 69, 2, 221, 8974]
     * Sample Output: [299, 9271]
     *
     * @param array An array with the five positive integers
     * @throws IllegalArgumentException If the given array is null
     */
    public static String miniMaxSum(List<Integer> array) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException("The array can not be null!");
        }

        array.sort(Comparator.naturalOrder());

        long min = 0;
        for (int index = 0; index < 4; index++) {
            min += array.get(index);
        }

        long max = 0;
        for (int index = 1; index < 5; index++) {
            max += array.get(index);
        }

        return "(" + min + ", " + max + ")";
    }

    public static void main(String[] args) {
        var list1 = new Integer[] {
                1, 2, 3, 4, 5
        };
        var result1 = miniMaxSum(Arrays.asList(list1)); // 10, 14
        System.out.println(result1);

        var list2 = new Integer[] {
                1, 3, 5, 7, 9
        };
        var result2 = miniMaxSum(Arrays.asList(list2)); // 16, 24
        System.out.println(result2);
    }
}
