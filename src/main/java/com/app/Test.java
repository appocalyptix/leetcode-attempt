package com.app;

import java.util.*;

public class Test {
    public static void main(String[] args) {
       TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return 0;
           }
       });
        //HashMap<String, String> map = new HashMap<>();

        map.put("b", "B");
        map.put("e", "E");
        map.put("c", "C");
        map.put("a", "A");
        map.put("1", "D");
        map.put("9", "Z");

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> itr = set.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().getKey());
        }
    }
}