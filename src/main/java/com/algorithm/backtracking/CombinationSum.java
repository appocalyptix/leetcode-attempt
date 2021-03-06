package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackingHelper(candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrackingHelper(int[] candidates, int target, List<Integer> list, List<List<Integer>> results) {

        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == -1) {
                continue;
            }

            if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(candidates[i]);
            backtrackingHelper(candidates, target - candidates[i], list, results);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        List<List<Integer>> ll = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);

        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }

    }
}
