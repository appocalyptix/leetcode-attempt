package com.ds.array;

/**
 * 647. Palindromic Substrings
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstring {

    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] a = s.toCharArray();
        int[] count = new int[1];
        for (int i = 0; i < s.length(); i++) {
            countPalindrome(a, i, i, count);
            countPalindrome(a, i, i + 1, count);
        }
        return count[0];
    }

    private void countPalindrome(char[] a, int s, int e, int[] count) {
        while (s >= 0 && e < a.length) {
            if (a[s] != a[e]) {
                break;
            }
            count[0]++;
            s--;
            e++;
        }
    }


    public static void main(String[] args) {
        PalindromicSubstring ps = new PalindromicSubstring();
        System.out.println(ps.countSubstrings("aac"));
    }
}
