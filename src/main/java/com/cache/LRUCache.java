package com.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    int maxCapacity;
    LinkedList<Item> orderList;
    HashMap<Integer, Item> dataMap;

    public LRUCache(int maxCapacity) {
        this.dataMap = new HashMap<>();
        this.orderList = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    public int get(int key) {
        int value = -1;
        if(dataMap.containsKey(key)) {
            Item item = dataMap.get(key);
            value = item.value;
            orderList.remove(item);
            orderList.addFirst(item);
        }
        return value;
    }

    public void put(int key, int value) {
        Item item = new Item(key, value);
        if (dataMap.containsKey(key)) {
            Item oldItem = dataMap.get(key);
            dataMap.remove(key);
            orderList.remove(oldItem);
        }
        if (orderList.size() == maxCapacity) {
            Item luItem = orderList.removeLast();
            dataMap.remove(luItem.key);
        }
        dataMap.put(key, item);
        orderList.addFirst(item);
    }

    static class Item {
        int key;
        int value;

        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
