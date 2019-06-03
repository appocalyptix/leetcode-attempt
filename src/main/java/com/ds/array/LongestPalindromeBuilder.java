package com.ds.array;

/**
 * 409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that
 * can be built with those letters. This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindromeBuilder {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] counter = new int[128];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }

        boolean oddFound = false;
        int count = 0;
        for (int i = 0; i < 128; i++) {
            if (counter[i] % 2 == 0) {
                count += counter[i];
            } else {
                oddFound = true;
                count += (counter[i] - 1);
            }
        }
        if (oddFound) {
            count++;
        }
        return count;
    }
}
