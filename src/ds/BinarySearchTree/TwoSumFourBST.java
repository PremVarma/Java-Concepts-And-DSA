package ds.BinarySearchTree;

import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;

import java.util.Arrays;

import static ds.BinarySearchTree.ConstructBSTFromPreOrder.constructBST;

// There exist of pair with Sum K (Note: Inorder will always be sorted in BST )
public class TwoSumFourBST {
    public static void main(String[] args) {
        TreeNode root = constructBST(Arrays.asList(5, 3, 2, 4, 6, 7));
        System.out.println(findTarget(root, 8));
    }

    public static boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        int i = left.next();
        int j = right.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j > k) {
                j = right.next();
            } else {
                i = left.next();
            }
        }
        return false;
    }
}
