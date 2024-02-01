package ds.BinaryTree.easy;

import ds.BinaryTree.TreeNode;

public class MaximumDepthInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(28);
        System.out.println("Maximum depth => " + maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
