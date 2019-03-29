package com.slidingwindow;

/**
 * #209
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 */
public class MinimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLength = 0;
        int length = 0;
        int windowStart = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            length++;
            if (sum >= s) {
                minLength = minLength == 0 ? length : Math.min(minLength, length);
                sum -= (nums[windowStart] + nums[i]);
                windowStart++;
                length -= 2;
                i--;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubArray mw = new MinimumSizeSubArray();
        System.out.println(mw.minSubArrayLen(7, new int[]{1,2,1,2}));
    }
}
