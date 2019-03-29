package com.twopointers;

/**
 * #26
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        int base = nums[0];
        int swapIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (base != nums[i]) {
                count++;
                base = nums[i];
                nums[swapIndex] = base;
                swapIndex++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(new int[]{1, 1, 1, 3, 5}));
    }
}
