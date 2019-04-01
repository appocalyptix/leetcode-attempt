package com.ds.tree;

public class BinarySearchTree {
    TreeNode root;

    public void insert(int key, String value) {
        TreeNode node = new TreeNode(key, value);
        if (root == null) {
            root = node;
            return;
        }
        boolean isLeftChild = false;
        TreeNode currentNode = root;
        TreeNode parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
            if (node.key >= currentNode.key) {
                isLeftChild = false;
                currentNode = currentNode.right;
            } else {
                isLeftChild = true;
                currentNode = currentNode.left;
            }
        }

        if (isLeftChild) {
            parentNode.left = node;
        } else {
            parentNode.right = node;
        }
    }

    public TreeNode getMin() {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        TreeNode parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
            currentNode = currentNode.left;
        }
        return parentNode;
    }

    public boolean remove(int key) {

        if (root == null) {
            return false;
        }
        TreeNode currentNode = root;
        TreeNode parentNode = null;
        TreeNode nodeToBeDeleted = null;
        boolean isLeftChild = false;

        while (currentNode != null) {
            if (key == currentNode.key) {
                nodeToBeDeleted = currentNode;
            } else if (key < currentNode.key) {
                isLeftChild = true;
                currentNode = currentNode.left;
            } else {
                isLeftChild = false;
                currentNode = currentNode.right;
            }
            parentNode = currentNode;
        }
        if (nodeToBeDeleted == null) {
            return false;
        }

        boolean isRoot = false;
        if (root == nodeToBeDeleted) {
            isRoot = true;
        }
        //Node have no children
        if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
            if (isRoot) {
                root = null;
            } else {
                addNode(parentNode, null, isLeftChild);
            }
            return true;
        }

        //One child is null
        else if (nodeToBeDeleted.left == null) {
            if (isRoot) {
                root = nodeToBeDeleted.right;
            } else {
                addNode(parentNode, nodeToBeDeleted.right, isLeftChild);
            }
            return true;
        } else if (nodeToBeDeleted.right == null) {

            if (isRoot) {
                root = nodeToBeDeleted.left;
            } else {
                addNode(parentNode, nodeToBeDeleted.left, isLeftChild);
            }

            return true;
        }
        //Has both children
        else {
            TreeNode smallestNode = nodeToBeDeleted;
            TreeNode parentToSmallest = null;

            while (smallestNode.left != null) {
                parentToSmallest = smallestNode;
                smallestNode = smallestNode.left;
            }
            parentToSmallest.left = null;

            smallestNode.left = nodeToBeDeleted.left;
            smallestNode.right = nodeToBeDeleted.right;
            if (isRoot) {
                root = smallestNode;
            } else {
                addNode(parentNode, smallestNode, isLeftChild);
            }
        }
        return true;
    }

    private void addNode(TreeNode parent, TreeNode node, boolean isLeft) {
        if (isLeft) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }
}
