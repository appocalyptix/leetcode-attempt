package com.algorithm.sort;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] arr = new int[max - min + 1];

        for (int i : nums) {
            arr[i - min]++;
        }
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            count += arr[i];
            if (count >= k) {
                return i + min;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        KthLargestElement kl = new KthLargestElement();
        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(kl.findKthLargest(a, 4));
    }
}
