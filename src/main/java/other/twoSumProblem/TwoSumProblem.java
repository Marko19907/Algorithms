package other.twoSumProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSumProblem {

    /**
     * A brute force approach to the two sum problem, O(n^2).
     */
    public static String bruteForceTwoSum(final int[] array, final int target) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException("The array can not be null!");
        }

        for (int x : array) {
            for (int y : array) {
                if ((x + y) == target) {
                    return "(" + x + "," + y +")";
                }
            }
        }

        return String.valueOf(-1);
    }

    /**
     * An optimized approach to the two sum problem, O(n).
     */
    public static String twoSumSetSolution(final int[] array, final int target) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException("The array can not be null!");
        }

        // Builds a set from the given array
        final Set<Integer> set = buildSet(array);

        for (int x : array) {
            int temp = target - x;
            if (set.contains(temp)) {
                return "(" + x + "," + temp +")";
            }
        }

        return String.valueOf(-1);
    }

    /**
     * Returns a set from the given array, O(n).
     */
    private static Set<Integer> buildSet(final int[] array) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static void main(String[] args) {
        final int[] array = new int[] {
                1, 3, 6, 4, 2
        };

        System.out.println(bruteForceTwoSum(array, 10)); // (6,4) for ex.
        System.out.println(bruteForceTwoSum(array, 14)); // -1, not possible

        System.out.println(twoSumSetSolution(array, 10));
        System.out.println(twoSumSetSolution(array, 14));
    }
}
