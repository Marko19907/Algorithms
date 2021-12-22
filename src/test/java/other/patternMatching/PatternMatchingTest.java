package other.patternMatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static other.patternMatching.PatternMatching.findBruteForce;

public class PatternMatchingTest {

    @Test
    @DisplayName("Tests the first case")
    public void testFirstCase() {
        // Arrange
        var string = "adbxcc";
        var pattern = "bxc";
        var result = 2;

        // Act
        final int output = findBruteForce(string.toCharArray(), pattern.toCharArray());

        // Assert
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Tests the second case")
    public void testSecondCase() {
        // Arrange
        var string = "abacaabaccabacabaabb";
        var pattern = "abacab";
        var result = 10;

        // Act
        final int output = findBruteForce(string.toCharArray(), pattern.toCharArray());

        // Assert
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Tests the third case")
    public void testThirdCase() {
        // Arrange
        var string = "abacehttjuj4uuticabaabb";
        var pattern = "ab7ab";
        var result = -1;

        // Act
        final int output = findBruteForce(string.toCharArray(), pattern.toCharArray());

        // Assert
        assertEquals(result, output);
    }
}