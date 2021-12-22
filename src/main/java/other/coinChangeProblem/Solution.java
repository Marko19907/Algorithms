package other.coinChangeProblem;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Solution {
    private final LinkedList<Integer> coins;

    public Solution() {
        this.coins = new LinkedList<>();
    }

    public void add(int coin) {
        this.coins.add(coin);
    }

    public void remove() {
        this.coins.removeLast();
    }

    public boolean isValid(int desiredPrice) {
        int total = 0;
        for (var any : this.coins) {
            total += any;
        }
        return total == desiredPrice;
    }

    public boolean isComplete(int desiredPrice) {
        int total = 0;
        for (var any : this.coins) {
            total += any;
        }
        return total >= desiredPrice;
    }

    public String toString() {
        return this.coins.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
