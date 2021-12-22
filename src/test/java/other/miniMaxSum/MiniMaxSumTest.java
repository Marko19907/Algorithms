package other.miniMaxSum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static other.miniMaxSum.MiniMaxSum.miniMaxSum;

public class MiniMaxSumTest {

    @Test
    @DisplayName("Tests the first provided case")
    public void testCase1() {
        // Arrange
        final var list = new Integer[] {
                1, 2, 3, 4, 5
        };
        final int max = 14;
        final int min = 10;

        // Act
        final int[] output = extractDigits(miniMaxSum(Arrays.asList(list)));

        // Assert
        assertTrue(Arrays.stream(output).anyMatch(number -> number == max));
        assertTrue(Arrays.stream(output).anyMatch(number -> number == min));
    }

    @Test
    @DisplayName("Tests the second provided case")
    public void testCase2() {
        // Arrange
        final var list = new Integer[] {
                7, 69, 2, 221, 8974
        };
        final int max = 9271;
        final int min = 299;

        // Act
        final int[] output = extractDigits(miniMaxSum(Arrays.asList(list)));

        // Assert
        assertTrue(Arrays.stream(output).anyMatch(number -> number == max));
        assertTrue(Arrays.stream(output).anyMatch(number -> number == min));
    }

    @Test
    @DisplayName("Tests a custom case")
    public void testCaseCustom() {
        // Arrange
        final var list = new Integer[] {
                1, 3, 5, 7, 9
        };
        final int max = 24;
        final int min = 16;

        // Act
        final int[] output = extractDigits(miniMaxSum(Arrays.asList(list)));

        // Assert
        assertTrue(Arrays.stream(output).anyMatch(number -> number == max));
        assertTrue(Arrays.stream(output).anyMatch(number -> number == min));
    }

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
}