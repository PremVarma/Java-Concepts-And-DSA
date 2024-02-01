package ds.BinaryTree.easy;

import ds.BinaryTree.TreeNode;

public class DiameterOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Tree is balanced : " + diameterOfBinaryTree(root));
    }

    private static int height(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, max);
        int rh = height(node.right, max);
        max[0] = Math.max(max[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        return height(root, max);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static int diameterOfBinaryTreeBF(TreeNode node) { // N^2
        if (node == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int lh = height(node.left);
        int rh = height(node.right);

        // Calculate the diameter passing through the current node
        int currentDiameter = lh + rh + 1;

        // Recursively calculate the diameter for left and right subtrees
        int leftDiameter = diameterOfBinaryTreeBF(node.left);
        int rightDiameter = diameterOfBinaryTreeBF(node.right);

        // Return the maximum of the three diameters
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
}
