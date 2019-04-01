package com.algorithm.slidingwindow;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        return findDuplicateRec(nums, 0, nums.length - 1);
    }

    private int findDuplicateRec(int[] nums, int s, int e) {
        if (s >= e) {
            return -1;
        }
        if (nums[s] == nums[e]) {
            return nums[s];
        }
        int num1 = findDuplicateRec(nums, s + 1, e);
        if (num1 != -1) {
            return num1;
        }
        return findDuplicateRec(nums, s, e - 1);
    }

    public static void main(String[] args) {
        DuplicateNumber dn = new DuplicateNumber();
        System.out.println(dn.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
