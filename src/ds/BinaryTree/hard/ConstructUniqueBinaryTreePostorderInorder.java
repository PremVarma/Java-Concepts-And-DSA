package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConstructUniqueBinaryTreePostorderInorder {
    public static void main(String[] args) {
        List<Integer> inOrder = new ArrayList<>(Arrays.asList(40, 20, 50, 10, 60, 30));
        List<Integer> postOrder = new ArrayList<>(Arrays.asList(40, 50, 20, 60, 30, 10));

        System.out.print("Inorder Vector: ");
        printList(inOrder);

        System.out.print("PostOrder Vector: ");
        printList(postOrder);

        TreeNode root = buildTree(postOrder, inOrder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
        System.out.println();
    }

    private static TreeNode buildTree(List<Integer> postOrder, List<Integer> inOrder) {
        if (inOrder == null || postOrder == null || inOrder.size() != postOrder.size()) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            map.put(inOrder.get(i), i);
        }
        return buildTree(inOrder, 0, inOrder.size() - 1, postOrder, 0, postOrder.size() - 1, map);
    }

    private static TreeNode buildTree(List<Integer> inOrder, int iStart, int iEnd, List<Integer> postOrder, int pStart, int pEnd, HashMap<Integer, Integer> map) {
        if (pStart > pEnd || iStart > iEnd) return null;
        TreeNode root = new TreeNode(postOrder.get(pEnd));
        int indexRoot = map.get(postOrder.get(pEnd));
        int numsLeft = indexRoot - iStart;
        root.left = buildTree(inOrder, iStart, indexRoot - 1, postOrder, pStart, pStart + numsLeft - 1, map);
        root.right = buildTree(inOrder, indexRoot + 1, iEnd, postOrder, pStart + numsLeft, pEnd - 1, map);
        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static void printList(List<Integer> vec) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }
        System.out.println();
    }
}
