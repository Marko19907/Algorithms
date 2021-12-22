package other.josephusProblem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static other.josephusProblem.JosephusProblem.josephusRecursively;

public class JosephusProblemTest {

    @Test
    @DisplayName("Tests the Josephus problem algo with a small input")
    public void testJosephusSmall() {
        // Arrange
        final int n = 4;
        final int k = 3;
        final int result = 1;

        // Act
        final int output = josephusRecursively(n, k);

        // Assert
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Tests the Josephus problem algo with a medium input")
    public void testJosephusMedium() {
        // Arrange
        final int n = 21;
        final int k = 5;
        final int result = 12;

        // Act
        final int output = josephusRecursively(n, k);

        // Assert
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Tests the Josephus problem algo with a large input")
    public void testJosephusLarge() {
        // Arrange
        final int n = 50;
        final int k = 30;
        final int result = 42;

        // Act
        final int output = josephusRecursively(n, k);

        // Assert
        assertEquals(result, output);
    }
}