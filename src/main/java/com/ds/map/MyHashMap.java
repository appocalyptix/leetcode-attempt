package com.ds.map;

public class MyHashMap {

    private int initialCapacity;
    private int loadFactor;
    private Node[] data;




    private static class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
