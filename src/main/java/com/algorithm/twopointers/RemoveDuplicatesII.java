package com.algorithm.twopointers;

/**
 * #80
 * <p>
 * Given a sorted array numbers, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 1;
        int count = 1;
        int base = nums[0];
        int swapIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (base != nums[i]) {
                k = 1;
                count++;
                base = nums[i];
                nums[i] = nums[swapIndex];
                nums[swapIndex] = base;
                swapIndex++;
            } else if (k < 2) {
                k++;
                count++;
                swapIndex++;
            }
            if (k == 2) {
                nums[swapIndex - 1] = base;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII rd = new RemoveDuplicatesII();
        int[] a = { 1, 1, 1, 1};
        int b = rd.removeDuplicates(a);

        for (int i = 0; i < b; i++) {
            System.out.println(a[i]);
        }
    }
}
