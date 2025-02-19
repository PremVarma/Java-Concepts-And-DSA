package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        changeTree(root);
    }

    public static void changeTree(TreeNode root) {
        if (root == null) return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;
    }
}
