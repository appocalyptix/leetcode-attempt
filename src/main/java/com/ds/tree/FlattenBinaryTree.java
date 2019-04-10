package com.ds.tree;

/**
 * #114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        flattenRec(root);
    }

    public void flattenRec(TreeNode node) {

        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.right == null && node.left != null) {
            node.right = node.left;
            node.left = null;
        } else if(node.right != null && node.left != null) {
            TreeNode rightMostNode = getRightMostNode(node.left);
            if (rightMostNode != null) {
                rightMostNode.right = node.right;
            } else {
                node.left.right = node.right;
            }
            node.right = node.left;
            node.left = null;
        }
        flattenRec(node.right);
    }

    private TreeNode getRightMostNode(TreeNode node) {
        TreeNode right = null;
        if (node == null) {
            return null;
        }
        while (node != null) {
            right = node;
            node = node.right;
        }
        return right;
    }

    /**
     * Flattens the tree, not as given in the example
     */
    public void flattenRec2(TreeNode node) {

        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.right == null && node.left != null) {
            node.right = node.left;
            node.left = null;
        } else if(node.right != null && node.left != null) {
            TreeNode rightMostNode = getRightMostNode(node);
            rightMostNode.right = node.left;
            node.left = null;
        }
        flattenRec2(node.right);
    }
}
