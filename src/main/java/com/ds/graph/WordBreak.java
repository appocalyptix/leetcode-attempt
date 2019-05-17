package com.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;


/**
 * 139. Word Break
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        wordDict.sort(Collections.reverseOrder());
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        Set<String> set = new HashSet<>();

        while (!q.isEmpty()) {
            String str = q.poll();
            for (String w : wordDict) {
                if (w.length() > str.length()) {
                    continue;
                }
                if (str.startsWith(w)) {
                    if (str.equals(w)) {
                        return true;
                    }
                    String newStr = str.substring(w.length());
                    if (!set.contains(newStr)) {
                        q.add(newStr);
                        set.add(newStr);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> l = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(wb.wordBreak(s, l));
    }
}
