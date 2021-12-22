package other.textInFrame;

import java.util.Arrays;

public class TextInFrame {

    private static final String LINE_BREAK = "\n";

    /**
     * Prints out the given String array to the console in a frame of stars with the given edge.
     * For example: the list ["Hello", "World", "in", "a", "frame"] with the edge = 2
     * gets printed as:
     *                  *********
     *                  * Hello *
     *                  * World *
     *                  * in    *
     *                  * a     *
     *                  * frame *
     *                  *********
     * @param array The array to print, not null
     * @param edge The * + number of spaces on each line
     * @throws IllegalArgumentException If the given array is null
     */
    public static void textInFrame(String[] array, int edge) {
        // Guard conditions
        if (array == null) {
            throw new IllegalArgumentException("The array can not be null!");
        }
        if (edge < 2) {
            throw new IllegalArgumentException("The edge can not be smaller than 2!");
        }

        final int longestWord = findLongestWordLength(array);
        final String bound = "*".repeat(longestWord + edge + edge);
        final String edgeLeft = "*" + " ".repeat(edge - 1);
        final String edgeRight = " ".repeat(edge - 1) + "*";

        final StringBuilder builder = new StringBuilder();

        builder.append(bound).append(LINE_BREAK);
        for (String line : array) {
            builder.append(edgeLeft)
                   .append(line)
                   .append(" ".repeat(longestWord - line.length()))
                   .append(edgeRight)
                   .append(LINE_BREAK);
        }
        builder.append(bound);

        System.out.println(builder);
    }

    /**
     * Returns the length of the longest word from the given String array.
     */
    private static int findLongestWordLength(String[] array) {
        // Guard condition
        if (array == null) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(array)
                .mapToInt(String::length)
                .max()
                .getAsInt();
    }

    public static void main(String[] args) {
        String[] textArray = new String[] {
                "Hello", "World", "in", "a", "frame"
        };
        textInFrame(textArray, 2);

        textInFrame(textArray, 5);
    }
}
