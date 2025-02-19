package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

public class FindElement {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        TreeNode target = findElementBST(root, 12);
        System.out.println("Element Found: " + target);
    }

    private static TreeNode findElementBST(TreeNode curr, int x) {
        if (curr == null) return null;
        while (curr != null && curr.data != x) {
            if (x > curr.data) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr;
    }
}
