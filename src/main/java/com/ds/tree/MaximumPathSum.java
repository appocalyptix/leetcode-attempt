package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumPathSum {

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] max = {Integer.MIN_VALUE};

        Map<TreeNode, Integer> map = new HashMap<>();
        maxToOffer(root, max, map);
        return max[0];
    }

    private int maxToOffer(TreeNode node, int[] max, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }
        int leftMax = maxToOffer(node.left, max, map);
        int rightMax = maxToOffer(node.right, max, map);

        int nMax = Math.max(leftMax, rightMax);

        if ((nMax + node.val) < 0) {
            nMax = 0;
        } else {
            nMax += node.val;
        }
        map.put(node, nMax);

        max[0] = Math.max(max[0], node.val + leftMax + rightMax);
        return nMax;
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
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(-1);


        TreeNode n8 = new TreeNode(1);
        TreeNode n9 = new TreeNode(2);
        TreeNode n0 = new TreeNode(3);

        n1.right = n2;
        n1.left = n3;

        n3.left = n4;
        n3.right = n5;

        n6.left = n7;
        // n6.right = n8;
        n8.left = n9;
        n8.right = n0;

        MaximumPathSum ms = new MaximumPathSum();
        System.out.println(ms.maxPathSum(n1));
    }
}
