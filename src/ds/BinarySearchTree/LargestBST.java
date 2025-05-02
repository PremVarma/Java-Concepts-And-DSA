package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

import java.util.Arrays;

import static ds.BinarySearchTree.ConstructBSTFromPreOrder.constructBST;

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = constructBST(Arrays.asList(1, 5, 8, 10, 15, 7));
        System.out.println(findLargestBST(root).maxSize);
    }

    private static NodeValue findLargestBST(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = findLargestBST(root.left);
        NodeValue right = findLargestBST(root.right);
        if (left.maxNode < root.data && root.data < right.minNode) {
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}
