package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestElementBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);

        System.out.println("Kth Smallest and Largest node: " + findSmallest(treeNode, 4));
    }

    private static List findSmallest(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int kLargest = list.get(list.size() - key);
        int kSmallest = list.get(key - 1);
        return Arrays.asList(kSmallest, kLargest);
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}
