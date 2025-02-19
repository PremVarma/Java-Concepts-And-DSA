package ds.BinarySearchTree;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;

public class DeleteNodeFromBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode node = deleteNode(root, 3);
        System.out.println();
    }

    private static TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }

    private static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.data == key) {
            return helper(root);
        }

        TreeNode curr = root;
        while (curr != null) {
            if (curr.data > key) {
                if (curr.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (curr.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return curr;
    }
}
