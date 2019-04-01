package com.algorithm.twopointers;

/**
 * #75
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color
 * red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {


    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; i++) {

            if (nums[i] == 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = 0;
                nums[i] = temp;
                zeroIndex++;

            }
            if (nums[i] == 2) {
                int temp = nums[twoIndex];
                nums[twoIndex] = 2;
                nums[i] = temp;
                twoIndex--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] a = {1, 1, 2};
        sc.sortColors(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}