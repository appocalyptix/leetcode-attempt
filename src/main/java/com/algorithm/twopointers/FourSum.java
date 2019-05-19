package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 18. 4Sum
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Set<String> set = new HashSet<>();
        Map<Integer, List<KV[]>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(target - sum)) {
                    List<KV[]> kvList = map.get(target - sum);
                    for (KV[] arr : kvList) {
                        if (i == arr[0].key || i == arr[1].key || j == arr[0].key || j == arr[1].key) {
                            continue;
                        }
                        List<Integer> l = Arrays.asList(nums[i], nums[j], arr[0].val, arr[1].val);
                        Collections.sort(l);
                        String s = "" + l.get(0) + l.get(1) + l.get(2) + l.get(3);
                        if (!set.contains(s)) {
                            set.add(s);
                            res.add(l);
                        }
                    }
                }
                List<KV[]> l = map.getOrDefault(sum, new ArrayList<>());
                l.add(new KV[]{new KV(i, nums[i]), new KV(j, nums[j])});
                map.put(sum, l);
            }
        }
        return res;
    }

    private static class KV {
        int key;
        int val;

        KV(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        FourSum fs = new FourSum();
        List<List<Integer>> ll = fs.fourSum(nums, -1);

        for (List<Integer> l : ll) {
            for (int i : l) {
                System.out.print(" > " + i);
            }
            System.out.println("\n");
        }
    }
}
