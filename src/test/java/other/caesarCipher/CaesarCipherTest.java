package other.caesarCipher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static other.caesarCipher.CaesarCipher.caesarCipher;
import static other.caesarCipher.CaesarCipher.caesarCipherWithCase;

public class CaesarCipherTest {

    @Test
    @DisplayName("Tests the case insensitive version of caesar's cipher")
    public void testCaesarCipher() {
        // Arrange
        final String input = "There's-a-starman-waiting-in-the-sky";
        final String result = "wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb";
        final int k = 3;

        // Act
        String output = caesarCipher(input, k);

        // Assert
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Tests the case sensitive version of caesar's cipher")
    public void testCaesarCipherWithCase() {
        // Arrange
        final String input = "Always-Look-on-the-Bright-Side-of-Life";
        final String result = "Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj";
        final int k = 5;

        // Act
        String output = caesarCipherWithCase(input, k);

        // Assert
        assertEquals(result, output);
    }
}