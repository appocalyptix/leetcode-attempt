package com.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * #322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of
 * coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) {
            return Integer.MAX_VALUE;
        }

        return coinChangeDP(coins, amount, new HashMap<>());

    }

    private int coinChangeDP(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }
            int count = coinChangeDP(coins, amount - coins[i], map);
            if (count != -1) {
                min = Math.min(min, count);
            }
        }

        min = min == Integer.MAX_VALUE ? -1 : min + 1;
        map.put(amount, min);
        return min;
    }
}
