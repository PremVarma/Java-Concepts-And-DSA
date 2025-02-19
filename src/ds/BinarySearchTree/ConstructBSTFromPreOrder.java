package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

import java.util.List;

public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        List<Integer> preOrder = List.of(8, 5, 1, 7, 10, 12, 9);
        TreeNode root = constructBST(preOrder);
        traversal(root);
    }

    private static void traversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        traversal(root.left);
        traversal(root.right);
    }

    private static TreeNode construct(List<Integer> preOrder, Integer max, int[] arr) {
        if (arr[0] == preOrder.size() || preOrder.get(arr[0]) > max) return null;
        TreeNode root = new TreeNode(preOrder.get(arr[0]++));
        root.left = construct(preOrder, root.data, arr);
        root.right = construct(preOrder, max, arr);
        return root;
    }

    private static TreeNode constructBST(List<Integer> preOrder) {
        return construct(preOrder, Integer.MAX_VALUE, new int[]{0});
    }
}
