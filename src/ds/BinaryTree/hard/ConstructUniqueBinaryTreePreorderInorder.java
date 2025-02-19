package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConstructUniqueBinaryTreePreorderInorder {
    public static void main(String[] args) {
        List<Integer> inorder = new ArrayList<>(Arrays.asList(40,20,50,10,60,30));
        List<Integer> preorder = new ArrayList<>(Arrays.asList(10,20,40,50,30,60));

        System.out.print("Inorder Vector: ");
        printList(inorder);

        System.out.print("Preorder Vector: ");
        printList(preorder);

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
        System.out.println();
    }

    private static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, map);
        return root;
    }

    private static TreeNode buildTree(List<Integer> preorder, int preStart, int preEnd, List<Integer> inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder.get(preStart));
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right =  buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1,inEnd, map);
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
