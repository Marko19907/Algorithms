package other.josephusProblem;

public class JosephusProblem {

    /**
     * Calculates the josephus problem recursively with the general formula.
     * @param n The number of people, from n=1 to inf
     * @param k The number of passes for each rotation
     * @return The last person with the ball
     */
    public static int josephusRecursively(int n, int k) {
        // Base case
        if (n == 1) {
            return 1;
        }

        return ((josephusRecursively(n - 1, k) + k - 1) % n) + 1;
    }

    public static void main(String[] args) {
        System.out.println(josephusRecursively(5, 3));

        System.out.println(josephusRecursively(1, 3));

        System.out.println(josephusRecursively(50, 50));
    }
}
