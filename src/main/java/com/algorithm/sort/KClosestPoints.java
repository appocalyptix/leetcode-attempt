package com.algorithm.sort;

import java.util.Arrays;

/**
 * #973. K Closest Points to Origin
 * <p>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * Here, the distance between two points on a plane is the Euclidean distance.
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * <p>
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {

        if (points.length == 0 || points.length < k) {
            return points;
        }
        sort(points, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void sort(int[][] points, int start, int end) {

        if (start >= end) {
            return;
        }
        int[] pivot = points[end];
        int i = start;
        int j = start - 1;

        while (i <= end) {
            if (isCloser(pivot, points[i]) && j < end) {
                j++;
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
            }
            i++;
        }

        sort(points, start, j - 1);
        sort(points, j + 1, end);
    }

    private boolean isCloser(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2)) >= Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
    }

    public static void main(String[] args) {
        KClosestPoints kp = new KClosestPoints();
        int[][] p = kp.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        System.out.println(p);
    }
}
