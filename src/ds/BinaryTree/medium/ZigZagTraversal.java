package ds.BinaryTree.medium;

import ds.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        boolean flag = true; // Direction is left -> right
        while (!queue.isEmpty()) {
            int leveSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < leveSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag == true) subList.add(queue.poll().data);
                else subList.add(0, queue.poll().data);
            }
            flag = !flag;
            result.add(subList);
        }
        return result;
    }
}
