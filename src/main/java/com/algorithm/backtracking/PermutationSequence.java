package com.algorithm.backtracking;

/**
 * #60. Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        boolean[] choices = new boolean[n + 1];
        choices[0] = true;
        return backtrackHelper(n, k, choices, new StringBuilder(), new int[]{0}, 0);
    }

    public String backtrackHelper(int n, int k, boolean[] choices, StringBuilder chosen, int[] seqCount, int count) {

        if (count == n) {
            seqCount[0]++;
            if (k == seqCount[0]) {
                return chosen.toString();
            }
            return null;
        }
        for (int i = 0; i < choices.length; i++) {
            if (choices[i]) {
                continue;
            }
            choices[i] = true;
            chosen.append(i);
            String seq = backtrackHelper(n, k, choices, chosen , seqCount, count + 1);
            if (seq != null) {
                return seq;
            }
            chosen.deleteCharAt(chosen.length() -1);
            choices[i] = false;
        }
        return null;
    }

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println("----------------------");
        System.out.println(ps.getPermutation(3, 3));
    }
}
