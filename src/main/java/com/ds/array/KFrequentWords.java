package com.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        if (k == 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        List<String> res = new ArrayList<>();
        if (k >= list.size()) {
            list.forEach(x -> res.add(x.getKey()));
        }
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        KFrequentWords kf = new KFrequentWords();
        String[] l = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ll = kf.topKFrequent(l, 2);

        for (String s : ll) {
            System.out.println(s);
        }


    }
}
