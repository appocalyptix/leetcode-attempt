package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 47. Permutations II
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        int[] chosen = new int[nums.length];
        Arrays.fill(chosen, Integer.MIN_VALUE);
        boolean[] choices = new boolean[nums.length];
        Set<List<Integer>> result = new HashSet<>();
        permuteUniqueHelper(nums, chosen, choices, result, 0);
        return new ArrayList<>(result);
    }

    private void permuteUniqueHelper(int[] nums, int[] chosen, boolean[] choices, Set<List<Integer>> result, int k) {
        if (k == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int i : chosen) {
                if (i != Integer.MIN_VALUE) {
                    l.add(i);
                }
            }
            result.add(l);
        }

        for (int i = 0; i < nums.length; i++) {
            if (choices[i]) {
                continue;
            }
            chosen[k] = nums[i];
            choices[i] = true;
            permuteUniqueHelper(nums, chosen, choices, result, k + 1);
            choices[i] = false;
            chosen[k] = Integer.MIN_VALUE;

        }
    }

    public static void main(String[] args) {
        Map<char[], List<String>> map = new HashMap<>();
        PermutationsII p = new PermutationsII();
        List<List<Integer>> ll = p.permuteUnique(new int[]{1, 1, 2});

        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }

}
