package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurnTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(6);

        System.out.println(timeToBurnTree(root, root.left.right.right.data));
    }

    private static TreeNode makeParentPointers(TreeNode root, Map<TreeNode, TreeNode> parentTrack, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode targetNode = null;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.data == target) targetNode = current;
            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return targetNode;
    }

    private static int timeToBurnTree(TreeNode root, int target) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        TreeNode startNode = makeParentPointers(root, parentTrack, target);
        int minTime = findMinTime(root, parentTrack, startNode);
        return minTime;
    }

    private static int findMinTime(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode startNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(startNode, true);
        int minDistance = 0;
        while (!queue.isEmpty()) {
            boolean anyNodeBurn = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && visited.get(currentNode.left) == null) {
                    queue.offer(currentNode.left);
                    visited.put(currentNode.left, true);
                    anyNodeBurn = true;
                }
                if (currentNode.right != null && visited.get(currentNode.right) == null) {
                    queue.offer(currentNode.right);
                    visited.put(currentNode.right, true);
                    anyNodeBurn = true;
                }
                if (parentTrack.get(currentNode) != null && visited.get(parentTrack.get(currentNode)) == null) {
                    queue.offer(parentTrack.get(currentNode));
                    visited.put(parentTrack.get(currentNode), true);
                    anyNodeBurn = true;
                }
            }
            if (anyNodeBurn) minDistance++;
        }
        return minDistance;
    }
}
