package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> map = new HashMap<>();

        for (List<String> t : tickets) {
            addToMap(map, t);
        }

        Collection<List<String>> values = map.values();
        Iterator<List<String>> itr = values.iterator();
        while (itr.hasNext()) {
            Collections.sort(itr.next());
        }

        String src = "JFK";
        List<String> list = new ArrayList<>();
        list.add(src);

        List<List<String>> result = new ArrayList<>();
        findItineraryHelper(map, result, list, src);

        return result.get(0);
    }

    private void findItineraryHelper(Map<String, List<String>> map, List<List<String>> result, List<String> l, String src) {
        if (result.size() > 0) {
            return;
        }
        if (map.isEmpty()) {
            List<String> list = new ArrayList<>(l);
            result.add(list);
            return;
        }

        if (!map.containsKey(src)) {
            return;
        }

        List<String> list = new ArrayList<>(map.get(src));

        for (String dest : list) {
            {
                List<String> t = new ArrayList<>();
                t.add(src);
                t.add(dest);

                l.add(dest);
                removeFromMap(map, t);

                findItineraryHelper(map, result, l, dest);

                l.remove(l.size() - 1);
                addToMap(map, t);
            }
        }
    }


    private void addToMap(Map<String, List<String>> map, List<String> t) {
        if (!map.containsKey(t.get(0))) {
            map.put(t.get(0), new ArrayList<>());
        }
        map.get(t.get(0)).add(t.get(1));
    }

    private void removeFromMap(Map<String, List<String>> map, List<String> t) {
        if (!map.containsKey(t.get(0))) {
            return;
        }

        List<String> list = map.get(t.get(0));

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(t.get(1))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.remove(index);
        }
        if (list.isEmpty()) {
            map.remove(t.get(0));
        } else {
            map.put(t.get(0), list);
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        String[][] s = {{"EZE", "AXA"}, {"TIA", "ANU"}, {"ANU", "JFK"}, {"JFK", "ANU"}, {"ANU", "EZE"}, {"TIA", "ANU"}, {"AXA", "TIA"}, {"TIA", "JFK"}, {"ANU", "TIA"}, {"JFK", "TIA"}};

        List<List<String>> t = new ArrayList<>();

        for (String[] a : s) {
            t.add(Arrays.asList(a));
        }

        List<String> l = ri.findItinerary(t);

        for (String ss : l) {
            System.out.println(ss);
        }
    }
}
