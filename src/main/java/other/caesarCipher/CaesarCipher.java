package other.caesarCipher;

import java.util.HashMap;

public class CaesarCipher {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final HashMap<Character, Integer> map = createMap();

    /**
     * Applies caesar's cipher to a given String with the given k shift,
     * case-insensitive (upper case will be shifted to lower case).
     * @param s The String to encrypt
     * @param k The shift
     */
    public static String caesarCipher(String s, int k) {
        final StringBuilder builder = new StringBuilder();
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int position = map.get(c);
                position = (position + k) % alphabet.length;
                builder.append(alphabet[position]);
            }
            else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    /**
     * Applies caesar's cipher to a given String with the given k shift, case-sensitive.
     * @param s The String to encrypt
     * @param k The shift
     */
    public static String caesarCipherWithCase(String s, int k) {
        final StringBuilder builder = new StringBuilder();
        final String temp = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(temp.charAt(i))) {
                if (Character.isUpperCase(s.charAt(i))) {
                    char ch = (char) ((s.charAt(i) + k - 65) % 26 + 65);
                    builder.append(ch);
                }
                else {
                    char ch = (char) ((s.charAt(i) + k - 97) % 26 + 97);
                    builder.append(ch);
                }
            }
            else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    private static HashMap<Character, Integer> createMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < alphabet.length; index++) {
            map.put(alphabet[index], index);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("There's-a-starman-waiting-in-the-sky", 3));

        if (!caesarCipher("There's-a-starman-waiting-in-the-sky", 3)
                .equals("wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb")) {
            System.out.println("Broken function! #1");
        }


        System.out.println(caesarCipherWithCase("Always-Look-on-the-Bright-Side-of-Life", 5));

        if (!caesarCipherWithCase("Always-Look-on-the-Bright-Side-of-Life", 5)
                .equals("Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj")) {
            System.out.println("Broken function! #2");
        }
    }
}
