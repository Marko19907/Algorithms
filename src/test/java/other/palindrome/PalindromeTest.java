package other.palindrome;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static other.palindrome.Palindrome.isPalindrome;
import static other.palindrome.Palindrome.isPalindromeRecursive;

public class PalindromeTest {

    final String[] wordsPositive = new String[]{
            "level",
            "radar",
            "tacocat",
            "wasitacaroracatisaw",
            "anna",
            "r"
    };
    final String[] wordsNegative = new String[]{
            "samsung",
            "hello",
            "mommamademeeatmym&ms",
            "function",
            "rw",
            "abcda"
    };

    @Test
    @DisplayName("Tests the positive cases")
    public void testPositiveCases() {
        Arrays.stream(this.wordsPositive).forEach(word -> {
            if (word != null) {
                assertTrue(isPalindrome(word.toCharArray()));

                assertTrue(isPalindromeRecursive(word.toCharArray()));
            }
        });
    }

    @Test
    @DisplayName("Tests the negative cases")
    public void testNegativeCases() {
        Arrays.stream(this.wordsNegative).forEach(word -> {
            if (word != null) {
                assertFalse(isPalindrome(word.toCharArray()));

                assertFalse(isPalindromeRecursive(word.toCharArray()));
            }
        });
    }
}