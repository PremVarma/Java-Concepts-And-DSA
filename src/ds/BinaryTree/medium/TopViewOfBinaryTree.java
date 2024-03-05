package ds.BinaryTree.medium;

import ds.BinaryTree.TreeNode;
import systemdesign.lld.tictactoe.model.Pair;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        List<Integer> topViewList = getTopView(root);
        System.out.println("Top View of Binary Tree: " + topViewList);
    }

    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getFirst();
            int hd = current.getSecond();
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            if (node.left != null) queue.offer(new Pair<>(node.left, hd - 1));
            if (node.right != null) queue.offer(new Pair<>(node.right, hd + 1));
        }
        result.addAll(map.values());
        return result;
    }
}
