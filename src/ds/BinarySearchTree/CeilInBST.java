package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

public class CeilInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        int ceil = findCeil(root, 12);
        System.out.println("Element Found: " + ceil);
    }

    private static int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        int ceil = -1;
        while (root != null) {
            if(root.data == key) {
                ceil = root.data;
                return ceil;
            }
            if(key > root.data){
                root = root.right;
            }else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
