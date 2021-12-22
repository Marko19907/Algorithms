package other.digitsInInteger;

public class DigitsInInteger {

    /**
     * Returns the number of digits in a given number.
     */
    public static int digits(int input) {
        input = Math.abs(input);
        int digits = 0;
        int temp = 1;

        while (temp <= input) {
            temp *= 10;
            digits++;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(digits(10));
        System.out.println(digits(150));
        System.out.println(digits(-100));
        System.out.println(digits(0));
    }
}
