package com.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * #76
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 */
public class MinimumWindowSubstring {
    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        int[] a = new int[128];
        String minWindow = "";
        String window = null;
        int windowStart = 0;
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length() && windowStart < s.length(); i++) {
            a[s.charAt(i)]--;
            if (windowFound(a)) {
                window = s.substring(windowStart, i + 1);
                if (minWindow.equals("")) {
                    minWindow = window;
                } else if (window.length() < minWindow.length()) {
                    minWindow = window;
                }
                a[s.charAt(windowStart)]++;
                a[s.charAt(i)]++;
                windowStart++;
                i--;
            }
        }
        return minWindow;
    }

    private boolean windowFound(int[] a) {
        for (int i : a) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }


    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }


        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();



        String minWindow = s;
        String window = null;
        int start = 0;
        int j = 0;
        boolean isMatchStart = false;



        for (int i = start; i < s.length() && start < s.length(); i++) {

            if (s.charAt(i) == t.charAt(j)) {
                if(!isMatchStart) {
                    isMatchStart = true;
                    start = i;
                }
                j++;
                if (j == t.length()) {
                    window = s.substring(start, i +1);
                    if (window.length() < minWindow.length()) {
                        minWindow = window;
                    }
                }
            } else {

            }

        }
        return minWindow;
    }

    public static void main(String[] args) {
       // MinimumWindowSubstring m = new MinimumWindowSubstring();
       // System.out.println(m.minWindow2("abc", "cba"));
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<String> l2 = Arrays.asList("a", "b", "d");
        Set<List<String>> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        System.out.println(set.size());
    }


}
