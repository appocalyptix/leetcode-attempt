package com.ds.array;

/**
 * 986. Interval List Intersections
 * <p>
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be
 * represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] a, int[][] b) {

        if (a.length == 0 || b.length == 0) {
            return new int[1][1];
        }

        int maxLen = a.length >= b.length ? a.length : b.length;
        int[][] res = new int[maxLen][2];
        int i = 0;
        int j = 0;
        while (i< a.length && j < b.length) {
           // b[i][0] > b[j]
        }

        return null;
    }
}
