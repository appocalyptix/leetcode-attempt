package com.ds.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new EntryComparator());

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    private static class EntryComparator implements Comparator<Map.Entry<Integer, Integer>> {

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    }

    public static void main(String[] args) {
        KFrequentElements ke = new KFrequentElements();
        int[] ii = {1, 1, 1, 2, 2, 3};
        List<Integer> l = ke.topKFrequent(ii, 2);
        for (int i : l) {
            System.out.println(i);
        }
    }
}
