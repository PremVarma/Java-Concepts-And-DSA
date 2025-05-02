package ds.BinarySearchTree;
import com.sun.source.tree.Tree;
import ds.BinaryTree.TreeNode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;

import static ds.BinarySearchTree.ConstructBSTFromPreOrder.constructBST;

// Inorder + Iterative Approach
public class BSTIterator {
    private static final Deque<TreeNode> stack = new ArrayDeque<>();
    private static final Deque<TreeNode> prevStack = new ArrayDeque<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

//    public static void main(String[] args) {
//        TreeNode root = constructBST(Arrays.asList(7, 3, 2, 1, 6, 5, 4, 10, 9, 8));
//        BSTIterator bstIterator = new BSTIterator(root, false);
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.prev());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.hasNext());
//
//    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public boolean hasPrev() {
        return !stack.isEmpty();
    }

    int prev() {
        if (!hasPrev()) throw new NoSuchElementException("No previous element");
        TreeNode currentNode = prevStack.pop();
        return currentNode.data;
    }


    int next() {
        if (!hasNext()) throw new NoSuchElementException("No next element");
        TreeNode currentNode = stack.pop();
        if (!reverse) {
            prevStack.push(currentNode);
            pushAll(currentNode.right);
        } else {
            pushAll(currentNode.left);
        }
        return currentNode.data;

    }

    void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}
