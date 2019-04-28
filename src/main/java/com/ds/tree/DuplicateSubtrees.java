package com.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        helper(root, map, list);
        return list;
    }

    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) {
            return "X";
        }

        String str = node.val + helper(node.left, map, list) + helper(node.right, map, list);
        System.out.println(str);
        map.put(str, map.getOrDefault(str, 0) + 1);

        if (map.get(str) == 2) {
            list.add(node);
        }
        return str;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length ==0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, map, new int[]{0}, 0, inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inMap, int[] preindex, int start, int end) {

        if(start == end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preindex[0]]);
        int ind = inMap.get(preindex[0]);
        preindex[0]++;

        node.left = helper(preorder, inMap, preindex, start, ind);
        node.right = helper(preorder, inMap, preindex, ind, end);

        return node;

    }
    public static void main(String[] args) {
        DuplicateSubtrees dt = new DuplicateSubtrees();

        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(0);

        n1.left = n2;
        n2.left = n4;

        n1.right = n3;
        n3.right = n5;
        n5.right = n6;
        List<TreeNode> l = dt.findDuplicateSubtrees(n1);
        System.out.println(l);
    }
}
