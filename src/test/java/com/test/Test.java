package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();


        int[] a = new int[128];
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();

        for (int i = 0; i < tArr.length; i++) {
            addToMap(map, tArr[i]);
            addToMap(map2, tArr[i]);
        }

        String minWindow = "";
        String window = null;
        int start = 0;

        for (int k = start; k < s.length() && start < s.length(); k++) {
            removeFromMap(map, sArr[k]);

            if (map.isEmpty()) {
                window = s.substring(start, k + 1);

                if (minWindow.equals("")) {
                    minWindow = window;
                } else {
                    minWindow = minWindow.length() > window.length() ? window : minWindow;
                }

                if (map2.containsKey(sArr[start])) {
                    addToMap(map, sArr[start]);
                }
                start++;
            }
        }
        return minWindow;
    }

    private static void addToMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private static void removeFromMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            int i = map.get(c);
            if (i == 1) {
                map.remove(c);
            } else {
                map.put(c, i - 1);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
       // l.add

    }
}
