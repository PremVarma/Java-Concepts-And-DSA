package ds.BinaryTree.hard;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeUsingLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        printInorder(deserialized);
    }

    private static void printInorder(TreeNode root){
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static TreeNode deserialize(String serialized) {
        if (serialized == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = serialized.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("n ");
                continue;
            }
            result.append(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return result.toString();
    }
}
