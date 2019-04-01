package com.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * #3
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0;
        int length = 0;
        int windowStart = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() && windowStart < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                maxLength = Math.max(maxLength, length);
                set.remove(s.charAt(windowStart));
                windowStart++;
                length--;
                i--;
            } else {
                set.add(s.charAt(i));
                length++;
            }
        }
        return Math.max(maxLength, length);
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("bbbbb"));

    }
}
