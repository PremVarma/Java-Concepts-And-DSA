package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

public class CountNodesCompleteBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        if (left == right) return ((2 << (left)) - 1); // 2 ^ height - 1
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getHeightLeft(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static int getHeightRight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
