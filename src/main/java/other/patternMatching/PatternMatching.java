package other.patternMatching;

public class PatternMatching {

    /**
     * Returns the lowest index at which the given
     * substring pattern begins in the given text (or else, -1).
     * @throws IllegalArgumentException If the text or the pattern is null
     */
    public static int findBruteForce(final char[] text, final char[] pattern) {
        // Guard conditions
        if (text == null || pattern == null) {
            throw new IllegalArgumentException("The arguments can not be null!");
        }

        final int textLength = text.length;
        final int patternLength = pattern.length;

        for (int index = 0; index < textLength; index++) {
            int pointer = 0;
            while (pointer < patternLength && text[index + pointer] == pattern[pointer]) {
                pointer++;
            }
            if (pointer == patternLength) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var string1 = "adbxcc";
        var pattern1 = "bxc";
        System.out.println(findBruteForce(string1.toCharArray(), pattern1.toCharArray()));

        if (findBruteForce(string1.toCharArray(), pattern1.toCharArray()) != 2) {
            System.out.println("Broken on case #1");
        }

        var string2 = "abacaabaccabacabaabb";
        var pattern2 = "abacab";
        System.out.println(findBruteForce(string2.toCharArray(), pattern2.toCharArray()));

        if (findBruteForce(string2.toCharArray(), pattern2.toCharArray()) != 10) {
            System.out.println("Broken on case #2");
        }

        var string3 = "abacehttjuj4uuticabaabb";
        var pattern3 = "ab7ab";
        System.out.println(findBruteForce(string3.toCharArray(), pattern3.toCharArray()));

        if (findBruteForce(string3.toCharArray(), pattern3.toCharArray()) != -1) {
            System.out.println("Broken on case #3");
        }
    }
}
