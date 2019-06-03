package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Not perfect solution, does not work if the tree has duplicate nodes
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        treeTravarsal(root, sb1, true);
        treeTravarsal(root, sb2, false);

        sb1.deleteCharAt(sb1.lastIndexOf(","));
        sb2.deleteCharAt(sb2.lastIndexOf(","));
        return sb1.toString() + "/" + sb2.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] s1 = data.substring(0, data.indexOf("/")).split(",");
        String[] s2 = data.substring(data.indexOf("/") + 1).split(",");

        Map<Integer, Integer> inMap = new HashMap<>();
        int[] pre = new int[s2.length];

        for (int i = 0; i < s1.length; i++) {
            pre[i] = Integer.parseInt(s2[i]);
            inMap.put(Integer.parseInt(s1[i]), i);
        }

        return constructTree(pre, new int[]{0}, 0, pre.length, inMap);
    }

    private TreeNode constructTree(int[] pre, int[] preIndex, int start, int end, Map<Integer, Integer> inMap) {

        if (start == end) {
            return null;
        }

        int i = pre[preIndex[0]];
        TreeNode node = new TreeNode(i);
        preIndex[0]++;

        int ind = inMap.get(i);

        node.left = constructTree(pre, preIndex, start, ind, inMap);
        node.right = constructTree(pre, preIndex, ind +1, end, inMap);
        return node;
    }


    private void treeTravarsal(TreeNode node, StringBuilder sb, boolean isInOrder) {
        if (node == null) {
            return;
        }
        if (!isInOrder) {
            sb.append(node.val);
            sb.append(",");
        }
        treeTravarsal(node.left, sb, isInOrder);
        if (isInOrder) {
            sb.append(node.val);
            sb.append(",");
        }
        treeTravarsal(node.right, sb, isInOrder);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        SerializeDeserializeBinaryTree sd = new SerializeDeserializeBinaryTree();
        sd.serialize(n1);
    }
}
