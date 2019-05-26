package com.ds.tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        leftInOrder(root, sb1);
        rightInOrder(root, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void leftInOrder(TreeNode p, StringBuilder sb) {
        if (p == null) {
            sb.append("x");
            return;
        }
        leftInOrder(p.left, sb);
        sb.append(p.val);
        leftInOrder(p.right, sb);
    }

    private void rightInOrder(TreeNode p, StringBuilder sb) {
        if (p == null) {
            sb.append("x");
            return;
        }
        rightInOrder(p.right, sb);
        sb.append(p.val);
        rightInOrder(p.left, sb);
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
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.right = n2;
        n1.left = n3;

       // n2.left = n4;
        n2.right = n4;

       // n3.left = n6;
        n3.right = n7;

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(n1));

    }
}
