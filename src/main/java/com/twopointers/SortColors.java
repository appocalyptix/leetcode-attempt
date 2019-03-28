package com.twopointers;

/**
 * #75
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color
 * red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] nums) {

/io9-000000000000000x = 0;
        int twoIndex = nums.length -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            while (nums[twoIndex] != 0) {
                twoIndex--;
            }
            int swapIndex;
            if (nums[i] == 0) {
                swapIndex = zeroIndex;
            } else if (nums[i] == 2) {
                swapIndex = twoIndex;
            }
        }
//    =]
\





\\;; p