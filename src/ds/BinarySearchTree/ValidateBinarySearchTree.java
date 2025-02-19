package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println("Binary Tree: " + validate(root));
    }

    private static boolean validate(TreeNode root) {
        return validateWithRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateWithRange(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.data >= max || root.data <= min) return false;
        return validateWithRange(root.left, min, Long.valueOf(root.data)) &&
                validateWithRange(root.right, Long.valueOf(root.data), max);
    }
}
