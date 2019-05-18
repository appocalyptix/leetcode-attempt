package com.ds.array;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] a = s.toCharArray();
        String[] res = new String[]{""};
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            palindromeFinder(a, i, i, res, map);
            palindromeFinder(a, i, i + 1, res, map);
        }
        return res[0];
    }

    private void palindromeFinder(char[] a, int s, int e, String[] res, Map<String, Boolean> map) {
        while (s >= 0 && e < a.length) {
            String key = new String(a, s, e - s + 1);
            if (map.containsKey(key)) {
                if (map.get(key)) {
                    s--;
                    e++;
                    continue;
                } else {
                    break;
                }
            }

            if (a[s] != a[e]) {
                map.put(key, false);
                break;
            }
            map.put(key, true);
            if (key.length() > res[0].length()) {
                res[0] = key;
            }
            s--;
            e++;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
        System.out.println(lp.longestPalindrome("v1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111a"));
    }
}
