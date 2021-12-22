package other.digitsInInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static other.digitsInInteger.DigitsInInteger.digits;

public class DigitsInIntegerTest {

    private static final HashMap<Integer, Integer> cases = createCasesMap();

    private static HashMap<Integer, Integer> createCasesMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(10, 2);
        map.put(150, 3);
        map.put(-100, 3);
        map.put(0, 0);
        map.put(14981153, 8);
        return map;
    }

    @Test
    @DisplayName("Tests all the cases from the cases map")
    public void testCases() {
        cases.forEach((input, result) -> {
            int output = digits(input);
            assertEquals(result, output);
        });
    }
}