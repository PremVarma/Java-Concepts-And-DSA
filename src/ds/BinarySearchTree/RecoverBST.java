package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

import java.util.Arrays;

import static ds.BinarySearchTree.ConstructBSTFromPreOrder.constructBST;

public class RecoverBST {
    static TreeNode first;
    static TreeNode prev;
    static TreeNode middle;
    static TreeNode last;

    public static void main(String[] args) {
//        3
//    1       4
//        2
//      Not valid BST (L<N<R)
        TreeNode root = constructBST(Arrays.asList(3, 1, 4, 2));
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && (root.data < prev.data)) {
            if (first != null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
