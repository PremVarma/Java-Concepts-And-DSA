package ds.BinaryTree.easy;

import ds.BinaryTree.TreeNode;

import java.util.*;


public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        preOrderTraversal(root);
        System.out.println();
        System.out.println("Inorder Traversal");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Postorder Traversal");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("Levelorder Traversal");
        System.out.println(levelOrderTraversal(root));
        System.out.println();
        System.out.println("Preorder Iterative Traversal");
        System.out.println(iterativePreorderTraversal(root1));
        System.out.println();
        System.out.println("InOrder Iterative Traversal");
        System.out.println(iterativeInOrderTraversal(root));
        System.out.println();
        System.out.println("PostOrder Iterative Traversal Two Stacks");
        System.out.println(iterativePostOrderTraversalTwoStacks(root));
        System.out.println();
        System.out.println("PostOrder Iterative Traversal");
        System.out.println(iterativePostOrderTraversal(root));
        System.out.println();
        System.out.println("Pre In and Post Traversal");
        traversal(root);
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ansList = new LinkedList<>();
        if (root == null) return ansList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            ansList.add(subList);
        }
        return ansList;
    }

    static List<Integer> iterativePreorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            preOrder.add(root.data);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return preOrder;
    }

    static List<Integer> iterativeInOrderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                inOrder.add(node.data);
                node = node.right;
            }
        }
        return inOrder;
    }

    static List<Integer> iterativePostOrderTraversalTwoStacks(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) return postOrder;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.poll().data);
        }
        return postOrder;
    }

    static List<Integer> iterativePostOrderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> postOrder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    postOrder.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        postOrder.add(temp.data);
                    }
                } else {
                    curr = temp;
                }

            }
        }
        return postOrder;
    }

    static void traversal(TreeNode root) {
        Deque<Pair> stack = new ArrayDeque<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) return;
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.num == 1) {
                preOrder.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if (pair.node.left != null) {
                    stack.push(new Pair(pair.node.left, 1));
                }
            } else if (pair.num == 2) {
                inOrder.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if (pair.node.right != null) {
                    stack.push(new Pair(pair.node.right, 1));
                }
            }else{
                postOrder.add(pair.node.data);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }
}

class Pair {
    public TreeNode node;
    public int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
