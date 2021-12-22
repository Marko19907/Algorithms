package other.parenthesesCheck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static other.parenthesesCheck.ParenthesesCheck.checkParentheses;
import static other.parenthesesCheck.ParenthesesCheck.checkParenthesesOptimized;

public class ParenthesesCheckTest {

    private static final HashMap<String, Integer> casesSet = buildTestSet();

    /**
     * Builds the test cases set.
     */
    private static HashMap<String, Integer> buildTestSet() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("(a+1)/(2+c)", -1);
        map.put("(a+(2-c)*3", 0);
        map.put("(a+b)*3)+c", 7);
        map.put("a+b/c", -1);
        return map;
    }

    @Test
    @DisplayName("Tests the original parentheses check algorithm")
    public void testCases() {
        casesSet.forEach((key, value) -> {
            int output = checkParentheses(key.toCharArray());
            assertEquals(value, output);
        });
    }

    @Test
    @DisplayName("Tests the optimized parentheses check algorithm")
    public void testCasesOptimized() {
        casesSet.forEach((key, value) -> {
            int output = checkParenthesesOptimized(key.toCharArray());
            assertEquals(value, output);
        });
    }
}