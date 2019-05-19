package com.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 173. Binary Search Tree Iterator
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 */
public class BSTIterator {

    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new ArrayDeque<>();
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        queue.add(node.val);
        inOrderTraversal(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
