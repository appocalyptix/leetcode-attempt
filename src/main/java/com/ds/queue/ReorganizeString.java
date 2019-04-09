package com.ds.queue;

import java.util.PriorityQueue;

/**
 * #767. Reorganize String
 * <p>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same. *
 * If possible, output any possible result.  If not possible, return the empty string
 */
public class ReorganizeString {
    public String reorganizeString(String s) {

        if (s.length() <= 1) {
            return s;
        }

        char[] str = s.toCharArray();
        int[] count = new int[26];

        for (char c : str) {
            count[c - 'a']++;
        }

        PriorityQueue<Item> queue = new PriorityQueue<>();

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                queue.add(new Item(count[i], (char) (i + 'a')));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            if (queue.size() == 1 && queue.peek().count >= 2) {
                return "";
            }

            int k = 0;
            Item[] items = new Item[2];
            while (k <= 1 && queue.size() > 0) {
                sb.append(queue.peek().c);
                items[k] = queue.poll();
                k++;
            }

            for (int i = 0; i < 2; i++) {
                if (items[i] != null && items[i].count > 1) {
                    items[i].count--;
                    queue.add(items[i]);
                }
            }
        }
        return sb.toString();
    }

    private static class Item implements Comparable<Item> {
        int count;
        char c;

        Item(int count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public int compareTo(Item o) {
            return o.count - this.count;
        }
    }

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("aab"));
    }
}
