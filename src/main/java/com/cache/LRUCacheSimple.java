package com.cache;

import java.util.HashMap;

public class LRUCacheSimple {
    private Dnode orderHead;
    private Dnode orderTail;
    private HashMap<Integer, Dnode> dataMap;
    private int maxCapacity;
    private int size;

    public LRUCacheSimple(int maxCapacity) {
        this.dataMap = new HashMap<>();
        this.maxCapacity = maxCapacity;
        this.size = 0;
    }

    public int get(int key) {
        int value = -1;
        if (dataMap.containsKey(key)) {
            Dnode node = dataMap.get(key);
            value = node.value;
            if (maxCapacity > 1) {
                moveToTheFront(node);
            }
        }
        return value;
    }

    private void moveToTheFront(Dnode node) {

        if (node == orderTail) {
            orderTail = node.previous;
            orderTail.next = null;

            node.previous = null;
            node.next = orderHead;
            orderHead.previous = node;
            orderHead = node;

        } else if (node != orderHead) {
            node.previous.next = node.next;
            node.next.previous = node.previous;

            node.previous = null;
            node.next = this.orderHead;
            orderHead.previous = node;
            this.orderHead = node;
        }
    }

    public void put(int key, int value) {
        Dnode node = new Dnode(key, value);
        if (size == 0) {
            orderTail = node;
            orderHead = node;
        }
        if (size == 1 && maxCapacity != 1) {
            orderTail.previous = node;
            node.next = orderHead;
            orderHead = node;
        } else if (size < maxCapacity) {
            node.next = orderHead;
            orderHead.previous = node;
            orderHead = node;
        } else if (size == maxCapacity) {
            node.next = orderHead;
            orderHead.previous = node;
            orderHead = node;

            if (!dataMap.containsKey(key)) {
                dataMap.remove(orderTail.key);
            }
            orderTail = orderTail.previous;
            orderTail.next = null;
            size--;
        }
        dataMap.put(key, node);
        size++;
    }

    static class Dnode {
        int key;
        int value;
        Dnode previous;
        Dnode next;

        Dnode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
