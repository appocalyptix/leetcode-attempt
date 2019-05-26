package com.ds.tree;

/**
 * 543. Diameter of Binary Tree
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5

 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class BinaryTreeDiameter {

    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getPathsize(root);
        return max;
    }

    private int getPathsize(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getPathsize(node.left);
        int right = getPathsize(node.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
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
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.right = n2;
        n1.left = n3;

        n2.left = n4;
        n2.right = n5;

        BinaryTreeDiameter bd = new BinaryTreeDiameter();
        System.out.println(bd.diameterOfBinaryTree(n1));
    }
}
