package com.algorithm.slidingwindow;

/**
 * #53. Maximum Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int start = 0;
        // int end = 0;
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum >= sum) {
                sum = currentSum;
                // end = i;
            } else {
                currentSum = currentSum - (nums[start] + nums[i]);
                start++;
                i--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(nums));
    }
}
