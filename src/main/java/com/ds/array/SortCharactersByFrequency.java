package com.ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {

        if (s.length() <= 2) {
            return s;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, "").concat(String.valueOf(c)));
        }

        List<Map.Entry<Character, String>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().length() - o1.getValue().length());
        String str = "";

        for (Map.Entry<Character, String> e : list) {
           str =  str.concat(e.getValue());

        }
        return str;

    }
}
