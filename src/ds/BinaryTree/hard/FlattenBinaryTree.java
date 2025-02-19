package ds.BinaryTree.hard;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;
import ds.LinkedList.Node;

import java.util.*;

public class FlattenBinaryTree {
    static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
//        flattenBruteForce(root);
//        printLL(prev);
//
//        flattenBetter(root);
//        printLL(root);

        flattenOptimal(root);
        printLL(root);

    }

    private static void flattenOptimal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }

    }

    private static void flattenBetter(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();
            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }

    private static void printLL(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.right;
        }
    }

    private static void flattenBruteForce(TreeNode root) {
        if (root == null) return;
        flattenBruteForce(root.right);
        flattenBruteForce(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
