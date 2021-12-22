package other.palindrome;

import java.util.Arrays;

public class Palindrome {

    /**
     * Checks if the given fixed size char array is a palindrome.
     * @param givenWord The char array to check
     * @return True if the array contains a palindrome, false if empty and otherwise
     * @throws IllegalArgumentException If the char array is null
     */
    public static boolean isPalindrome(char[] givenWord) {
        // Guard conditions
        if (givenWord == null) {
            throw new IllegalArgumentException();
        }
        if (givenWord.length == 0) {
            return false;
        }

        int left = 0;
        int right = givenWord.length - 1;
        int index = 0;

        while (index < givenWord.length) {
            if (givenWord[left] != givenWord[right]) {
                return false;
            }
            if (left == right) {
                return true;
            }
            left++;
            right--;
            index++;
        }
        return true;
    }

    /**
     * Checks if the given fixed size char array is a palindrome in a recursive manner.
     * @param givenWord The char array to check
     * @return True if the array contains a palindrome, false if empty and otherwise
     * @throws IllegalArgumentException If the char array is null
     */
    public static boolean isPalindromeRecursive(char[] givenWord) {
        // Guard conditions
        if (givenWord == null) {
            throw new IllegalArgumentException();
        }
        if (givenWord.length == 0) {
            return false;
        }

        return isPalindromeRecursiveStep(givenWord, 0, givenWord.length - 1);
    }

    /**
     * A single step in the recursion.
     */
    private static boolean isPalindromeRecursiveStep(char[] givenWord, int start, int stop) {
        // Base case
        if (stop == 0 && start == givenWord.length - 1) {
            return true;
        }

        if (givenWord[start] != givenWord[stop]) {
            return false;
        }
        if (start == stop) {
            return true;
        }
        return isPalindromeRecursiveStep(givenWord, ++start, --stop);
    }

    public static void main(String[] args) {
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


        Arrays.stream(wordsPositive).forEach(word -> {
            if (word != null) {
                if (!isPalindrome(word.toCharArray())) {
                    System.out.println("Broken palindrome function on case: " + word);
                }
                if (!isPalindromeRecursive(word.toCharArray())) {
                    System.out.println("Broken palindrome function on case: " + word);
                }
            }
        });

        Arrays.stream(wordsNegative).forEach(word -> {
            if (word != null) {
                if (isPalindrome(word.toCharArray())) {
                    System.out.println("Broken palindrome function on case: " + word);
                }
                if (isPalindromeRecursive(word.toCharArray())) {
                    System.out.println("Broken palindrome function on case: " + word);
                }
            }
        });
    }
}
