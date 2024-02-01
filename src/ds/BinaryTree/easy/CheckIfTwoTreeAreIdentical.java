package ds.BinaryTree.easy;

import ds.BinaryTree.TreeNode;

public class CheckIfTwoTreeAreIdentical {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(-1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);

        System.out.println("Identical => " + isSameTree(node1, node2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
