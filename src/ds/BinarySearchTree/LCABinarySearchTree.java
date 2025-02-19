package ds.BinarySearchTree;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;

public class LCABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lcaOfBST(root, root.left, root.left.right).data);
    }

    private static TreeNode lcaOfBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.data;
        if (curr < p.data && curr < q.data) {
            return lcaOfBST(root.right, p, q);
        }
        if (curr > p.data && curr > q.data) {
            return lcaOfBST(root.left, p, q);
        }
        return root;
    }
}
