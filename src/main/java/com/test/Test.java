package com.test;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        while (num > 0) {
            if (num > 1 && num % 2 != 0) {
                return false;
            } else if (num > 4 && num < 8) {
                return false;
            }
            if (num == 1) {
                return true;
            }
            num = num >> 2;
        }
        return false;
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //set.add
    }
}
