package com.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            char[] arr = word.toCharArray();

            for (int i = 0; i < len; i++) {
                char c = arr[i];
                arr[i] = '*';
                String str = new String(arr);
                arr[i] = c;
                List<String> list = map.getOrDefault(str, new ArrayList<>());
                list.add(word);
                map.put(str, list);
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(beginWord, 0));
        Set<String> set = new HashSet<>();

        while (!q.isEmpty()) {
            Node n = q.poll();
            String s = n.val;

            if (set.contains(s)) {
                continue;
            }
            set.add(s);
            int l = n.level;

            if (s.equals(endWord)) {
                return l + 1;
            }

            char[] arr = s.toCharArray();
            for (int i = 0; i < len; i++) {
                char c = arr[i];
                arr[i] = '*';
                String str = new String(arr);
                arr[i] = c;
                List<String> adj = map.get(str);

                if (adj != null) {
                    for (String ss : adj) {
                        q.add(new Node(ss, l + 1));
                    }
                }
            }
        }
        return 0;
    }

    private static class Node {
        String val;
        int level;

        Node(String val, int level) {
            this.val = val;
            this.level = level;
        }
    }


    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hot", "dog", Arrays.asList("hot", "dot", "dog")));


    }
}
