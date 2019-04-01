package com.algorithm.slidingwindow;

/**
 * #76
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
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

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("a", "b"));
    }
}
