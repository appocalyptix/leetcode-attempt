package com.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        populate(root, map, 0);
        return new ArrayList<>(map.values());
    }

    private void populate(TreeNode node, TreeMap<Integer, List<Integer>> map, int col) {
        if (node == null) {
            return;
        }
        List<Integer> l = map.getOrDefault(col, new ArrayList<>());
        l.add(node.val);
        map.put(col, l);
        populate(node.left, map, col - 1);
        populate(node.right, map, col + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }
}
