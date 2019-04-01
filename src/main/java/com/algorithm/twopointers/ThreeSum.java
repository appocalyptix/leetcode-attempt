package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        if (nums.length < 3) {
            return mainList;
        }
        int iPrevious = Integer.MIN_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == iPrevious) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                if (nums[j] + nums[k] == 0 - nums[i]) {
                    mainList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k) {
                        if (nums[j] != nums[++j]) break;
                    }
                    while (j < k) {
                        if (nums[k] != nums[--k]) break;
                    }
                } else if (nums[j] + nums[k] > 0 - nums[i]) {
                    while (j < k) {
                        if (nums[k] != nums[--k]) break;
                    }
                } else {
                    while (j < k) {
                        if (nums[j] != nums[++j]) break;
                    }
                }
            }
            iPrevious = nums[i];
        }
        return mainList;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> ll = ts.threeSum(new int[]{1, 1, 1});

        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + "  ");
            }
            System.out.println("\n");
        }
    }
}
