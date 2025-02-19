package ds.BinaryTree.hard;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerializeUsingPreorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        String serialized = serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        TreeNode deserialized = deserialize(serialized);
    }


    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static TreeNode deserialize(String serialized) {
        Queue<String> queue = new LinkedList<>();
        if (serialized == "") return null;
        for (String value : serialized.split(",")) {
            queue.add(value);
        }
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String nodeValue = queue.poll();
        if (nodeValue.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.data).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


}
