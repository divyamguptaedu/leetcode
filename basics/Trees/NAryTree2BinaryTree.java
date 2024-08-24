import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/*
Transform the structure of an N-ary tree into a binary tree and then reverse the process to retrieve the original N-ary tree.
An N-ary tree is a tree where each node can have up to N children, while in a binary tree, each node can have at most two children.
Your task is to create an encoding and decoding method, ensuring that the N-ary tree can be converted into a binary tree and then accurately
reconstructed back into the N-ary form. The method you design can be implemented in any manner,
as long as it maintains the integrity of the original tree structure throughout the process

Here's an example for illustration:

        1
      / | \

> Input: root = [1,null,3,2,4,null,5,6]
>

 */

/*

*/

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
//    // Encodes an n-ary tree to a binary tree.
//    public static TreeNode encode(Node root) {
//        //Null check
//        if (root == null) {
//            return null;
//        }
//
//        //Create the root for the binary tree
//        TreeNode binaryRoot = new TreeNode(root.val);
//
//        //Check if no children present
//        if (root.children == null || root.children.isEmpty()) {
//            return binaryRoot;
//        }
//
//        //Start with the first child
//        binaryRoot.left = encode(root.children.get(0));
//
//        //Initialize current node for all children of root
//        TreeNode current = binaryRoot.left;
//        for (int i = 1; i < root.children.size(); i++) {
//            current.right = encode(root.children.get(i));
//            current = current.right;
//        }
//
//        return binaryRoot;
//    }
//
//    // Decodes your binary tree to an n-ary tree.
//    public static Node decode(TreeNode root) {
//        //Null check
//        if (root == null) {
//            return null;
//        }
//
//        //Get the root for nAry tree
//        Node nAryRoot = new Node(root.val, new ArrayList<>());
//
//        TreeNode current = root.left;
//
//        while (current != null) {
//            nAryRoot.children.add(decode(current));
//            current = current.right;
//        }
//
//        return nAryRoot;
//    }
    public static TreeNode encode(Node root) {
        if (root == null) return null;

        TreeNode binaryRoot = new TreeNode(root.val);
        Stack<Pair<Node, TreeNode>> stack = new Stack<>();
        stack.push(new Pair<>(root, binaryRoot));

        while (!stack.isEmpty()) {
            Pair<Node, TreeNode> currentPair = stack.pop();
            Node nAryNode = currentPair.getKey();
            TreeNode binaryNode = currentPair.getValue();

            TreeNode prev = null;
            for (Node child : nAryNode.children) {
                TreeNode newBinaryNode = new TreeNode(child.val);
                if (prev == null) {
                    binaryNode.left = newBinaryNode;
                } else {
                    prev.right = newBinaryNode;
                }
                prev = newBinaryNode;
                stack.push(new Pair<>(child, newBinaryNode));
            }
        }

        return binaryRoot;
    }

    // Iteratively decodes a binary tree to an n-ary tree.
    public static Node decode(TreeNode root) {
        if (root == null) return null;

        Node nAryRoot = new Node(root.val, new ArrayList<>());
        Stack<Pair<TreeNode, Node>> stack = new Stack<>();
        stack.push(new Pair<>(root, nAryRoot));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Node> currentPair = stack.pop();
            TreeNode binaryNode = currentPair.getKey();
            Node nAryNode = currentPair.getValue();

            TreeNode currentBinaryChild = binaryNode.left;
            while (currentBinaryChild != null) {
                Node newNAryNode = new Node(currentBinaryChild.val, new ArrayList<>());
                nAryNode.children.add(newNAryNode);
                stack.push(new Pair<>(currentBinaryChild, newNAryNode));
                currentBinaryChild = currentBinaryChild.right;
            }
        }

        return nAryRoot;
    }
}

class QuestionOneTest {
    Node originalNAryRoot;
    @BeforeEach
    void Setup() {
        Node root = new Node(1, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());
        Node five = new Node(5, new ArrayList<>());
        Node six = new Node(6, new ArrayList<>());
        Node seven = new Node(7, new ArrayList<>());
        Node eight = new Node(8, new ArrayList<>());
        Node nine = new Node(9, new ArrayList<>());
        Node ten = new Node(10, new ArrayList<>());
        root.children.add(two);
        root.children.add(three);
        root.children.add(four);
        two.children.add(five);
        two.children.add(six);
        two.children.add(seven);
        four.children.add(eight);
        four.children.add(nine);
        four.children.add(ten);
        originalNAryRoot = root;
    }

    @Test
    void TestOne() {
        TreeNode binaryNode = Codec.encode(originalNAryRoot);
        Node decodedNAryRoot = Codec.decode(binaryNode);
        assertTrue(isSameTree(originalNAryRoot, decodedNAryRoot));
    }

    boolean isSameTree(Node rootOne, Node rootTwo) {
        if (rootOne == null && rootTwo == null) return true;
        if (rootOne == null || rootTwo == null || rootOne.val != rootTwo.val) return false;

        if (rootOne.children.size() != rootTwo.children.size()) return false;

        for (int i = 0; i < rootOne.children.size(); i++) {
            if (!isSameTree(rootOne.children.get(i), rootTwo.children.get(i))) {
                return false;
            }
        }

        return true;
    }
}




























