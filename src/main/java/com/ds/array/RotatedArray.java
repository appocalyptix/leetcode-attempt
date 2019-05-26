package com.ds.array;

public class RotatedArray {
    public int search(int[] nums, int target) {

        return 0;
    }

    public int findPeak(int[] nums, int start, int end) {

        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;

        if ((mid - 1) == 0 || (mid + 1) == nums.length - 1) {
            return -1;
        }
        if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
            return mid;
        } else if (nums[mid - 1] < nums[mid]) {
            int res1 = findPeak(nums, mid + 1, end);
            if (res1 != -1) {
                return res1;
            }
        } else {
            int res2 = findPeak(nums, start, mid - 1);
            if (res2 != -1) {
                return res2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedArray ra = new RotatedArray();
        int[] a = {6, 7, 0, 1, 2, 3, 4, 5};
        System.out.println(ra.findPeak(a, 0, a.length - 1));
    }
}
