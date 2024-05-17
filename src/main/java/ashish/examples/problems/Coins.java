package ashish.examples.problems;

import java.util.List;

public class Coins {

    public static int calculateCoins(int amount) {
        List<Integer> coins = List.of(50, 25, 10, 5, 1);
        int totalCoins = 0;
        for (Integer coin : coins) {
            int coinNeeded = amount / coin;
            int remainder = amount % coin;
            totalCoins = totalCoins+coinNeeded;
            if (remainder == 0) {
                return totalCoins;
            }
            amount = remainder;
        }
        return totalCoins;
    }

    public static void main(String[] args) {
        System.out.println(calculateCoins(541));
    }
}
