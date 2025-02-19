package ds.BinarySearchTree;

import ds.BinaryTree.TreeNode;

public class FloorInBST {
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
        int ceil = findFloor(root, 15);
        System.out.println("Element Found: " + ceil);
    }

    private static int findFloor(TreeNode root, int key) {
        if (root == null) return -1;
        int floor = -1;
        while(root != null){
            if(root.data == key) {
                floor = root.data;
                return floor;
            }
            if(root.data < key){
                floor =  root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return floor;
    }
}
