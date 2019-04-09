package com.algorithm.sort;

import java.util.Arrays;

/**
 * #274. H-Index
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function
 * to compute the researcher's h-index. According to the definition of h-index on Wikipedia: "A scientist
 * has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no
 * more than h citations each."
 */
public class HIndex {
    public int hIndex(int[] citations) {

        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);

        int length = citations.length;

        int count = 0;
        for (int i = 1; i <= length; i++) {
            if (citations[length - i] >= i ) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        System.out.println(hi.hIndex(new int[]{1}));
    }
}
