package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
    doInOrder(this.root);
}

private void doInOrder(BstNode root) {
    if (root != null) {
        doInOrder(root.left); // traverse left subtree
        System.out.print(root.data + " "); // visit the root
        doInOrder(root.right); // traverse right subtree
    }
    // ToDo 1: complete InOrder Traversal 
}

public void preOrderTraversal() {
    doPreOrder(this.root);
}

private void doPreOrder(BstNode root) {
    if (root != null) {
        System.out.print(root.data + " "); // visit the root
        doPreOrder(root.left); // traverse left subtree
        doPreOrder(root.right); // traverse right subtree
    }
    // ToDo 2: complete the pre-order travesal . 
}

public Integer findHeight() {
    return findHeight(this.root);
}

private int findHeight(BstNode root) {
    if (root == null) {
        return -1;
    }
    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
    // ToDo 3: Find the height of a tree
}

public int getDepth(BstNode node) {
    return getDepth(this.root, node, 0);
}

private int getDepth(BstNode root, BstNode node, int depth) {
    if (root == null) {
        return -1;
    }
    if (root == node) {
        return depth;
    }
    int leftDepth = getDepth(root.left, node, depth + 1);
    if (leftDepth != -1) {
        return leftDepth;
    }
    return getDepth(root.right, node, depth + 1);
    //ToDo 4: complete getDepth of a node 
}

public void print() {
    System.out.println("\n==== BST Print ===== \n");
    print("", root, false);
}

private void print(String prefix, BstNode node, boolean isLeft) {
    if (node != null) {
        System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.data);
        print(prefix + (isLeft ? "|   " : "    "), node.left, true);
        print(prefix + (isLeft ? "|   " : "    "), node.right, false);
    }
    // ToDo 5: complete the print of the BST
}
}