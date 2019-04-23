package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * #78. Subsets
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 */
public class SebSets {
    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        boolean[] choices = {true, false};
        boolean[] chosen = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        subsetHelper(nums, choices, chosen, 0, results);
        return results;
    }

    private void subsetHelper(int[] nums, boolean[] choices, boolean[] chosen, int k, List<List<Integer>> results) {
        if (k == nums.length) {

            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (chosen[i]) {
                    l.add(nums[i]);
                }
            }
            results.add(l);
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            chosen[k] = choices[i];
            subsetHelper(nums, choices, chosen, k + 1, results);
        }
    }

    public static void main(String[] args) {
        SebSets set = new SebSets();
        List<List<Integer>> ll = set.subsets(new int[]{1, 1, 1});

        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }
}
