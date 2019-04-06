package com.cache;


import java.util.*;

public class LFUCache {
    Map<Integer, Integer> dataMap;
    Map<Integer, Integer> frequencyMap;
    TreeMap<Integer, List<Integer>> orderMap;
    int maxCapacity;
    int size;

    LFUCache(int maxCapacity) {
        dataMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        orderMap = new TreeMap<>();
        this.maxCapacity = maxCapacity;
        this.size = 0;
    }

    public int get(int key) {
        if (frequencyMap.containsKey(key)) {
            frequencyMap.put(key, frequencyMap.get(key) + 1);
        } else {
            frequencyMap.put(key, 1);
        }
        if (!dataMap.containsKey(key)) {
            return -1;
        }
        return dataMap.get(key);
    }

    public void put(int key, int value) {
        int frequency = 1;
        if (frequencyMap.containsKey(key)) {
            frequency += frequencyMap.get(key);
        }
        frequencyMap.put(key, frequency);

        if (size < maxCapacity) {
            dataMap.put(key, value);
            if (orderMap.containsKey(frequency)) {
                orderMap.get(frequency).add(key);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                orderMap.put(frequency, list);
            }
            size++;
            return;
        }

        if (size == maxCapacity && orderMap.lastKey() < frequency) {
            Integer keyToRemove = orderMap.lastEntry().getValue().remove(0);
            if (orderMap.lastEntry().getValue().size() == 0) {
                orderMap.remove(orderMap.lastKey());
            }
            List<Integer> list = new ArrayList<>();
            list.add(key);
            orderMap.put(frequency, list);
            dataMap.remove(keyToRemove);
            dataMap.put(key, value);
        }
    }


    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
    static class Item {
        int key;
        int value;


    }
}
