package com.algorithm.twopointers;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * Solution: solution is similar to 3Sum problem, only difference is that we need to keep track of closest sum and
 * absolute difference between sum and target, if we have a lower difference then  replace existing  difference and
 * closest sum with current values.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int closestSum = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                int lDiff = Math.abs(target - sum);

                if (lDiff < diff) {
                    diff = lDiff;
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest tc = new ThreeSumClosest();
        System.out.println(tc.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }


}
