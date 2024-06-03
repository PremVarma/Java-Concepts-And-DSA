package ds.BinaryTree.medium;

import ds.BinaryTree.TreeNode;
import systemdesign.lld.tictactoe.model.Pair;

import java.util.*;

public class RightSideOfBinaryTree {
    public static void main(String[] args) {
//        1
//     2     3
//        4
//           5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        List<Integer> rightSideView = rightSideView(root);
        System.out.println("Right View of Binary Tree: " + rightSideView);

        List<Integer> leftSideView = leftSideView(root);
        System.out.println("Left View of Binary Tree: " + leftSideView);
    }

    // We will reverse preorder and use NRL instead of NLR
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getRightSideView(root, 0, list);
        return list;
    }

    public static void getRightSideView(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        if (level == result.size()) result.add(root.data);
        getRightSideView(root.right, level + 1, result);
        getRightSideView(root.left, level + 1, result);
    }

    public static List<Integer> leftSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        getLeftSideView(root, 0, list);
        return list;
    }

    public static void getLeftSideView(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        if (level == result.size()) result.add(root.data);
        getRightSideView(root.left, level + 1, result);
        getRightSideView(root.right, level + 1, result);
    }

}