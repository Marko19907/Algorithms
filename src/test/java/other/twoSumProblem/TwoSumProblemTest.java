package other.twoSumProblem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static other.twoSumProblem.TwoSumProblem.bruteForceTwoSum;
import static other.twoSumProblem.TwoSumProblem.twoSumSetSolution;

public class TwoSumProblemTest {

    private static final int[] ARRAY_SMALL = new int[] {
            1, 5, 21, 34, 567, 890
    };
    private static final int[] ARRAY_LARGE = new int[] {
            1, 7, 18, 21, 25, 33, 35, 37, 61, 65, 69, 70, 90, 93, 94
    };

    /**
     * Returns all numbers from a given String in an array.
     */
    private static int[] extractDigits(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }

        return Arrays.stream(source.replaceAll("-", " -").split("[^-\\d]+"))
                .filter(s -> !s.matches("-?"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Returns the sum of a given array.
     * @throws IllegalArgumentException If the given array is null
     */
    private static int sumArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(array).sum();
    }

    @Test
    @DisplayName("Tests the brute force approach to the two sum problem on a small array")
    public void testBruteForceTwoSumSmall() {
        // Arrange
        final int target = 891;

        // Act
        String result = bruteForceTwoSum(ARRAY_SMALL, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), target);
    }

    @Test
    @DisplayName("Tests the brute force approach to the two sum problem on a large array")
    public void testBruteForceTwoSumLarge() {
        // Arrange
        final int target = 94 * 2;

        // Act
        String result = bruteForceTwoSum(ARRAY_LARGE, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), target);
    }

    @Test
    @DisplayName("Tests the brute force approach to the two sum problem on a small array, negative test")
    public void testBruteForceTwoSumSmallNegative() {
        // Arrange
        final int target = Integer.MAX_VALUE;

        // Act
        String result = bruteForceTwoSum(ARRAY_SMALL, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), -1);
    }

    @Test
    @DisplayName("Tests the brute force approach to the two sum problem on a large array, negative test")
    public void testBruteForceTwoSumLargeNegative() {
        // Arrange
        final int target = Integer.MAX_VALUE;

        // Act
        String result = bruteForceTwoSum(ARRAY_LARGE, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), -1);
    }

    @Test
    @DisplayName("Tests the two sum problem on a small array")
    public void testTwoSumSmall() {
        // Arrange
        final int target = 891;

        // Act
        String result = twoSumSetSolution(ARRAY_SMALL, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), target);
    }

    @Test
    @DisplayName("Tests the two sum problem on a large array")
    public void testTwoSumLarge() {
        // Arrange
        final int target = 94 * 2;

        // Act
        String result = twoSumSetSolution(ARRAY_LARGE, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), target);
    }

    @Test
    @DisplayName("Tests the two sum problem on a small array, negative test")
    public void testTwoSumSmallNegative() {
        // Arrange
        final int target = Integer.MAX_VALUE;

        // Act
        String result = twoSumSetSolution(ARRAY_SMALL, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), -1);
    }

    @Test
    @DisplayName("Tests the two sum problem on a large array, negative test")
    public void testTwoSumLargeNegative() {
        // Arrange
        final int target = Integer.MAX_VALUE;

        // Act
        String result = twoSumSetSolution(ARRAY_LARGE, target);

        // Assert
        assertEquals(sumArray(extractDigits(result)), -1);
    }
}