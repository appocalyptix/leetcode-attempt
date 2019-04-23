package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. Permutation
 *
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return Collections.emptyList();
        }

        int[] chosen = new int[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        permuteHelper(nums, chosen, results, 0);
        return results;
    }

    private void permuteHelper(int[] choices, int[] chosen, List<List<Integer>> result, int k) {
        if (k == choices.length) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < chosen.length; i++) {
                l.add(chosen[i]);
            }
            result.add(l);
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] == Integer.MAX_VALUE) {
                continue;
            }
            chosen[k] = choices[i];
            choices[i] = Integer.MAX_VALUE;
            permuteHelper(choices, chosen, result, k + 1);
            choices[i] = chosen[k];
        }
    }

    public static void main(String[] args) {
        Permutations pm = new Permutations();
        List<List<Integer>> ll = pm.permute(new int[]{1, 2, 3});
        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }
}
