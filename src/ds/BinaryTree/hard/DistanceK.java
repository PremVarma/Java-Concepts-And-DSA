package ds.BinaryTree.hard;

import ds.BinaryTree.TreeNode;

import java.util.*;

public class DistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(7);
        root.left.right.left = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(distanceK(root, root.left, 2));
    }

    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel == k) break;
            currLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null) {
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.data);
        }
        return result;
    }
}
