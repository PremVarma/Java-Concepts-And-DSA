package ds.BinaryTree.easy;

// HEIGHT ( LEFT ) - HEIGHT ( RIGHT ) <= 1

import ds.BinaryTree.TreeNode;

public class CheckForBalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Tree is balanced : " + isBalanced(root));
    }

    public static int findHeight(TreeNode root) {
        if (root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.left);
        if (Math.abs(lh - rh) > 1 || lh == -1 || rh == -1) return -1;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        return findHeight(root) == -1;
    }
}
