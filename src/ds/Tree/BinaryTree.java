package ds.Tree;

import java.util.*;

// Root -> Node  -> Leaf (No further connected node) - Two Children Max AT Any Level Max Node -> 2^n where N is height of tree starting from 0
// Max Height of Tree with height h is 2^h-1
public class BinaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node<Integer> root = createTree();
        inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println("Height => " + height(root));
        System.out.println("Level Order Traversal => ");
        levelOrderTraversal_BF(root, height(root));
        System.out.println("Size => " + size(root));
        System.out.println("Max Value => " + maxValue(root));
        System.out.println("Top View => " + topView(root));
        System.out.println("Flattern Binary Tree  => ");
        flatternBinaryTree(root); // Take head and print DLL
    }

    static Node<Integer> createTree() {
        Node<Integer> root = null;
        System.out.println("Enter Data");
        int data = sc.nextInt();
        if (data == -1) return null;
        root = new Node<Integer>(data);
        System.out.println("Enter left for " + data);
        root.left = createTree();
        System.out.println("Enter right for " + data);
        root.right = createTree();
        return root;

    }

    //    INORDER TRAVERSAL -> Left = Node = Right (LNR)
    static void inOrderTraversal(Node<Integer> root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    //    PREORDER TRAVERSAL -> Node = Left = Right (NLR)
    static void preOrderTraversal(Node<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //    POSTORDER TRAVERSAL -> Left = Right = Node (LRN)
    static void postOrderTraversal(Node<Integer> root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static void printCurrentLevel(Node<Integer> root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    //    Level Order Traversal - Brute Force
    static void levelOrderTraversal_BF(Node<Integer> root, int height) {
        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    void levelOrderTraversal_OP(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node<Integer> curr = queue.poll();
//            Handle new Line
            if (curr == null) {
                if (queue.isEmpty()) return;
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print(curr.data);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    //    Height Of Binary Tree
    static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //    Size Of Binary Tree => Total Node
    static int size(Node root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    //    Max Value of Node
    static int maxValue(Node<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maxValue(root.left), maxValue((root.right))));
    }

    //    Left and Right View Of Tree ( We can use Level Order Traversal to get left and right view)
    void printLeftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        for (Node curr : list) {
            System.out.println(curr.data + " ");
        }
    }

    //For Right view either change order of calling utilFunction recursively or remove if condition which will override value
    private void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
        if (root == null) return;
        if (list.get(level) == null) {
            list.set(level, root);
        }
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);
    }

    //    Top and Bottom View Of BTree
    static ArrayList<Integer> topView(Node<Integer> root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }
            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    //    Convert Binary Tree to Doubly Linked List
    static Node<Integer> prev = null, head = null;

    static void flatternBinaryTree(Node<Integer> root) {
        if (root == null) return;
        flatternBinaryTree(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        flatternBinaryTree(root.right);
    }

    //    Calculate diameter of BT (Number of nodes in largest path between two leaf node)
    static int diameter_BF(Node<Integer> root) { //N*N
        if (root == null) return 0;
        int dl = diameter_BF(root.left);
        int dr = diameter_BF(root.right);
        int curr = height(root.left) + height(root.right) + 1;
        return Math.max(curr, Math.max(dl, dr));
    }

    static int ans = 0;

    static int diameter_OP(Node<Integer> root) { // used as height function
        if (root == null) return 0;
        int lh = diameter_OP(root.left);
        int rh = diameter_OP(root.right);
        ans = Math.max(ans, 1 + lh + rh); // comment for height
        return 1 + Math.max(lh, rh);
    }

    //    Lowest Common Ancestor - (Parents and above )
    Node<Integer> lca(Node<Integer> root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node<Integer> left = lca(root.left, n1, n2);
        Node<Integer> right = lca(root.right, n1, n2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    //     Burn Tree
    public static int minTime(Node<Integer> root, int target) {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return ans;
    }

    static int burnAns = -1;

    public static int burn(Node<Integer> root, int target, Depth depth) {
        if (root == null) return 0;
        if (root.data == target) {
            depth.d = 1;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);
        int lh = burn(root.left, target, ld);
        int rh = burn(root.right, target, rd);
        if (ld.d != -1) {
            burnAns = Math.max(burnAns, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != -1) {
            burnAns = Math.max(burnAns, rd.d + 1 + lh);
        }
        return Math.max(lh, rh) + 1;
    }
}

class Node<T> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class Pair {
    int hd; // horizontal distance
    Node<Integer> node;

    public Pair(int hd, Node<Integer> node) {
        this.hd = hd;
        this.node = node;
    }
}

class Depth {
    int d;

    public Depth(int d) {
        this.d = d;
    }
}

