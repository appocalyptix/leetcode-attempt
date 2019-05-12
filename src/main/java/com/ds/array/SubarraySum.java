package com.ds.array;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > k) {
                sum = 0;
                start = i + 1;
                continue;
            }
            sum += nums[i];
            if (sum >= k) {

                while (sum >= k && start <= i) {
                    if (sum == k) {
                        count++;
                    }
                    sum -= nums[start];
                    start++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int[] n = {0,0,0,0};
        System.out.println(ss.subarraySum(n, 0));
    }
}
