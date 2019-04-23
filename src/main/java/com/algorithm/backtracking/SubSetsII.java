package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * #90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }

        boolean[] choices = {false, true};
        boolean[] chosen = new boolean[nums.length];
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, choices, chosen, results, 0);
        return new ArrayList<>(results);
    }

    private void subsetsWithDupHelper(int[] nums, boolean[] choices, boolean[] chosen, Set<List<Integer>> results, int k) {

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
            subsetsWithDupHelper(nums, choices, chosen, results, k + 1);
        }
    }

    public static void main(String[] args) {
        SubSetsII ss = new SubSetsII();

        List<List<Integer>> ll = ss.subsetsWithDup(new int[]{1, 2, 1});
        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }
}
