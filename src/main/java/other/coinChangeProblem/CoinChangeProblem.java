package other.coinChangeProblem;

public class CoinChangeProblem {

    /**
     * Function to find the total number of ways to get a change
     * of `desiredPrice` from an unlimited supply of coins in set `coins`.
     * @param coins The set of coins
     * @param desiredPrice The desired value
     */
    public static void findSolutions(int[] coins, int desiredPrice) {
        var current = new Solution();
        recurse(current, coins, desiredPrice);
    }

    private static void recurse(Solution current, int[] coins, int desiredPrice) {
        if (!current.isComplete(desiredPrice)) {
            for (var eachCoin : coins) {
                current.add(eachCoin);
                if (current.isValid(desiredPrice)) {
                    System.out.println(current);
                }
                else {
                    recurse(current, coins, desiredPrice);
                }
                current.remove();
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{
                10, 25, 50, 100
        };
        findSolutions(coins, 300);
    }
}
