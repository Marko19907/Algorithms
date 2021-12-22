package other.recursions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursionsTest {

    @Test
    @DisplayName("Test factorial calculations")
    public void testFactorial() {
        // Arrange
        int a = 0;
        int b = 0;

        // Act
        a = Recursions.factorial(5);
        b = Recursions.factorial(10);

        // Assert
        assertEquals(120, a);
        assertEquals(3628800, b);
    }

    @Test
    @DisplayName("Test negative factorial calculations")
    public void testFactorialNegative() {
        // Arrange
        int result = 0;
        boolean exceptionThrown = false;

        // Act
        try {
            result = Recursions.factorial(-4);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(exceptionThrown);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test factorial of 0")
    public void testZeroFactorial() {
        // Arrange
        int result = 0;

        // Act
        result = Recursions.factorial(0);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test the power function")
    public void testPowerFunction() {
        // Arrange
        int result = 0;

        // Act
        result = Recursions.factorial(0);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test the fibonacci function")
    public void testFibonacci() {
        // Arrange
        final HashMap<Integer, Integer> set = new HashMap<>();
        set.put(0,0);
        set.put(1,1);
        set.put(5,5);
        set.put(12,144);
        set.put(35,9227465);

        // Act
        set.forEach((key, value) -> {
            int temp = Recursions.fibonacci(key);

            // Assert
            assertEquals(temp, value);
        });
    }
}