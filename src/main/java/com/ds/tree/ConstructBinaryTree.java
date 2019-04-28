package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length ==0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, map, new int[1], 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inMap, int[] preindex, int start, int end) {

        if(start == end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preindex[0]]);
        int ind = inMap.get(preorder[preindex[0]]);
        preindex[0]++;
        node.left = helper(preorder, inMap, preindex, start, ind);
        node.right = helper(preorder, inMap, preindex, ind +1, end);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTree ct = new ConstructBinaryTree();
        int[] inoredr = {9,3,15,20,7};
        int[] preorder= {3,9,20,15,7};

        ct.buildTree(preorder, inoredr);
    }
}
