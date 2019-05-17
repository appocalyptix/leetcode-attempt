package com.ds.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 *
 * Create a timebased key-value store class TimeMap, that supports two operations.
 *
 * 1. set(string key, string value, int timestamp)
 *
 * Stores the key and value, along with the given timestamp.
 * 2. get(string key, int timestamp)
 *
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest timestamp_prev.
 * If there are no values, it returns the empty string ("").
 */
public class TimeMap {

    private Map<String, TreeMap<Integer, String>> dataMap;

    public TimeMap() {
        dataMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tm = dataMap.getOrDefault(key, new TreeMap<>());
        tm.put(timestamp, value);
        dataMap.put(key, tm);
    }

    public String get(String key, int timestamp) {

        if (dataMap.containsKey(key)) {
            Map.Entry<Integer, String> entry = dataMap.get(key).floorEntry(timestamp);
            if(entry == null) {
                return "";
            }
            return entry.getValue();
        }
        return "";
    }


}
