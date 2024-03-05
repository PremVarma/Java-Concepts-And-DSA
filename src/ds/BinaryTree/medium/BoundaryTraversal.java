package ds.BinaryTree.medium;

import ds.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);


        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);
        System.out.println(traverseBoundary(root));
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if (!isLeafNode(root)) result.add(root.data);
        addLeftBoundary(root, result);
        addLeafBoundary(root, result);
        addRightBoundary(root, result);
        return result;

    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeafNode(curr)) result.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    static void addLeafBoundary(TreeNode root, ArrayList<Integer> result) {
        if (isLeafNode(root)) {
            result.add(root.data);
            return;
        }
        if (root.left != null) addLeafBoundary(root.left, result);
        if (root.right != null) addLeafBoundary(root.right, result);
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.right;
        Deque<Integer> stack = new ArrayDeque<>();
        while (curr != null) {
            if (!isLeafNode(curr)) stack.push(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    private static boolean isLeafNode(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }
}
