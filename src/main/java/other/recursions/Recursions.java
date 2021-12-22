package other.recursions;

public class Recursions {

    /**
     * Calculates the factorial of a given number using recursion.
     * @param number The number to calculate the factorial of
     * @return The factorial of the given number
     * @throws IllegalArgumentException If the given number is negative
     */
    public static int factorial(int number) {
        // Guard condition
        if (number < 0) {
            throw new IllegalArgumentException("A factorial can not be negative!");
        }

        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    /**
     * Calculates the base^power recursively
     * @param base The base number
     * @param power The power of the base
     * @return The base^power of the two numbers
     * @throws IllegalArgumentException If both the base and power are 0
     */
    public static double power(int base, int power) {
        // Guard condition
        if (base == 0 && power == 0) {
            throw new IllegalArgumentException("0 to the power of 0 is undefined!");
        }

        // Base case
        if (power == 0) {
            return 1;
        }

        if (power > 0) {
            return base * power(base, power - 1);
        }
        else {
            return 1 / power(base, power * (-1));
        }
        //return power > 0 ? base * power(base, power - 1) : 1 / power(base, power * (-1));
    }

    /**
     * Calculates the base^power using a loop
     * @param base The base number
     * @param power The power of the base
     * @return The base^power of the two numbers
     * @throws IllegalArgumentException If both the base and power are 0
     */
    public static double powerLoop(int base, int power) {
        // Guard condition
        if (base == 0 && power == 0) {
            throw new IllegalArgumentException("0 to the power of 0 is undefined!");
        }

        double result = 1;
        if (power > 0) {
            int index = 0;
            while (index < power) {
                result *= base;
                index++;
            }
        }
        else {
            int index = power;
            while (index < 0) {
                result *= base;
                index++;
            }
            result = 1 / result;
        }
        return result;
    }

    /**
     * Calculates the n-th fibonacci number in the sequence recursively.
     * @param number The n-th fibonacci number
     * @return The n-th fibonacci number in the sequence
     */
    public static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {
        System.out.println(Recursions.factorial(5));
        System.out.println(Recursions.factorial(1));


        System.out.println(power(3, 4));
        System.out.println(power(5, -2));

        System.out.println(powerLoop(3, 4));
        System.out.println(powerLoop(5, -2));

        System.out.println("--------------------------");

        System.out.println(fibonacci(12));
    }
}
