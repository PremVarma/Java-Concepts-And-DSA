package ds.BinaryTree.hard;

import basics.generics.Pair;
import ds.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(9);

        int maxWidth = widthOfBinaryTree(root);
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }

    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().getSecond();
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int currentId = queue.peek().getSecond() - min;
                TreeNode node = queue.peek().getFirst();
                queue.poll();
                if (i == 0) first = currentId;
                if (i == size - 1) last = currentId;
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, currentId * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, currentId * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
