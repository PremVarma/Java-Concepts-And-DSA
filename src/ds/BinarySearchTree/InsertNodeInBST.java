package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

public class InsertNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        insertNode(root, 5);
    }

    private static TreeNode insertNode(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) return node;
        while (root != null) {
            if (node.data <= key) {
                if (node.right != null) node = node.right;
                else {
                    node.right = new TreeNode(key);
                    break;
                }
            } else {
                if (node.left != null) node = node.left;
                else {
                    node.left = new TreeNode(key);
                    break;
                }
            }
        }
        return root;
    }
}
