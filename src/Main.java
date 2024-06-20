import com.sun.source.tree.Tree;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        levelOrder2(root);
    }

    private static void levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque =  new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(node.left != null) {
                deque.offer(node.left);
            }
            if(node.right != null) {
                deque.offer(node.right);
            }
            list.add(node.data);
        }
        System.out.println(list);
    }

    private static void levelOrder2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Deque<TreeNode> deque =  new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int level =  deque.size();
            List<Integer> subList =  new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = deque.poll();
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
                subList.add(node.data);
            }
            list.add(subList);
        }
        System.out.println(list);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
