package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderII {

//    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (wordList.size() == 0) {
//            return 0;
//        }
//
//        Map<String, List<String>> map = populate(wordList);
//
//        Queue<KV> q = new ArrayDeque<>();
//        q.add(new KV(beginWord, new ArrayList<>()));
//        Set<String> set = new HashSet<>();
//
//        while (!q.isEmpty()) {
//            KV kv = q.poll();
//            String str = kv.k;
//
//            if (set.contains(str)) {
//                continue;
//            }
//            set.add(str);
//
//            if (str.equals(endWord)) {
//                kv.v.add(str);
//                return kv.v;
//            }
//            char[] c = str.toCharArray();
//            for (int i = 0; i < c.length; i++) {
//                char t = c[i];
//                c[i] = '*';
//                String s = new String(c);
//                c[i] = t;
//                List<String> l = map.get(s);
//                if (l != null) {
//                    for (String itm : l) {
//                        q.add(new KV(itm, kv.v + 1));
//                    }
//                }
//
//            }
//        }
//        return 0;
//    }

    private Map<String, List<String>> populate(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i ++) {
            char[] c = wordList.get(i).toCharArray();

            for(int j = 0; j < c.length; j ++) {
                char t = c[j];
                c[j] = '*';
                String s = new String(c);
                c[j] = t;

                List<String> list = map.getOrDefault(s, new ArrayList<>());
                list.add(wordList.get(i));
                map.put(s, list);
            }

        }
        return map;
    }

    private static class KV {
        String k;
        List<String> v;

        KV(String k, List<String> v) {
            this.k = k;
            this.v = v;
        }
    }
}
