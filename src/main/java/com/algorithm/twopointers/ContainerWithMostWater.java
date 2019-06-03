package com.algorithm.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        if (height.length <= 1) {
            return 0;
        }
        int s = 0;
        int e = height.length - 1;
        int max = 0;

        while (s < e) {
            int area = Math.min(height[s], height[e]) * (e - s);
            max = Math.max(max, area);

            if (height[s] <= height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return max;
    }
}
