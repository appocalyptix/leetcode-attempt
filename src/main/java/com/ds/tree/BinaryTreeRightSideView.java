package com.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you
 * an see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 *      1            <---
 *    /   \
 *   2     3         <---
 *   \     \
 *     5     4       <---
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        levelOrderTravel(root, 0, list);

        List<Integer> res = new ArrayList<>();
        for (List<Integer> l : list) {
            res.add(l.get(l.size() - 1));
        }
        return res;
    }

    private void levelOrderTravel(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        levelOrderTravel(node.left, level + 1, list);
        levelOrderTravel(node.right, level + 1, list);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
