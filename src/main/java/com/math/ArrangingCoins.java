package com.math;

/**
 * #441. Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }

        //Using formula sum od series 1, 2, 3, ..., k =  k(k +1)/2
        //and quadratic equation formula x = (-b +- sqrt(b^2 - 4ac))/2a
        double num1 = (-1 + Math.sqrt(1 + 4 * 2 * (long) n)) / 2;
        double num2 = (-1 - Math.sqrt(1 + 4 * 2 * (long) n)) / 2;
        return (int) Math.round(Math.floor(num1 > 0 ? num1 : num2));
    }

    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(1804289383));
    }
}
