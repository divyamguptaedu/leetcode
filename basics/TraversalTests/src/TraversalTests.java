import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

// In-order traversal
class InOrderTraversal {
    private List<Integer> result;

    public List<Integer> inorderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        result.add(node.val);
        traverse(node.right);
    }

    public List<Integer> inorderIterative(TreeNode root) {
        result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}

// Pre-order traversal
class PreOrderTraversal {
    private List<Integer> result;

    public List<Integer> preOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public List<Integer> preOrderIterative(TreeNode root) {
        result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}

// Post-order traversal
class PostOrderTraversal {
    private List<Integer> result;

    public List<Integer> postOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        traverse(node.right);
        result.add(node.val);
    }

    public List<Integer> postOrderIterative(TreeNode root) {
        result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != lastVisited) {
                    current = temp.right;
                } else {
                    temp = stack.pop();
                    result.add(temp.val);
                    lastVisited = temp;
                }
            }
        }
        return result;
    }
}

// Tests for all traversals
public class TraversalTests {
    TreeNode root;

    @BeforeEach
    private void setup() {
        TreeNode level4Node1 = new TreeNode(4);
        TreeNode level4Node2 = new TreeNode(7);
        TreeNode level4Node3 = new TreeNode(13);
        TreeNode level3Node1 = new TreeNode(1);
        TreeNode level3Node2 = new TreeNode(6, level4Node1, level4Node2);
        TreeNode level3Node3 = new TreeNode(14, level4Node3, null);
        TreeNode level2Node1 = new TreeNode(3, level3Node1, level3Node2);
        TreeNode level2Node2 = new TreeNode(10, null, level3Node3);
        root = new TreeNode(8, level2Node1, level2Node2);
    }

    @Test
    public void inorderRecursiveTest() {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> result = inOrderTraversal.inorderRecursive(root);
        List<Integer> expected = List.of(1, 3, 4, 6, 7, 8, 10, 13, 14);
        assertEquals(expected, result, "InOrder Recursive Test failed");
    }

    @Test
    public void inorderIterativeTest() {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> result = inOrderTraversal.inorderIterative(root);
        List<Integer> expected = List.of(1, 3, 4, 6, 7, 8, 10, 13, 14);
        assertEquals(expected, result, "InOrder Iterative Test failed");
    }

    @Test
    public void preOrderRecursiveTest() {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        List<Integer> result = preOrderTraversal.preOrderRecursive(root);
        List<Integer> expected = List.of(8, 3, 1, 6, 4, 7, 10, 14, 13);
        assertEquals(expected, result, "PreOrder Recursive Test failed");
    }

    @Test
    public void preOrderIterativeTest() {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        List<Integer> result = preOrderTraversal.preOrderIterative(root);
        List<Integer> expected = List.of(8, 3, 1, 6, 4, 7, 10, 14, 13);
        assertEquals(expected, result, "PreOrder Iterative Test failed");
    }

    @Test
    public void postOrderRecursiveTest() {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        List<Integer> result = postOrderTraversal.postOrderRecursive(root);
        List<Integer> expected = List.of(1, 4, 7, 6, 3, 13, 14, 10, 8);
        assertEquals(expected, result, "PostOrder Recursive Test failed");
    }

    @Test
    public void postOrderIterativeTest() {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        List<Integer> result = postOrderTraversal.postOrderIterative(root);
        List<Integer> expected = List.of(1, 4, 7, 6, 3, 13, 14, 10, 8);
        assertEquals(expected, result, "PostOrder Iterative Test failed");
    }
}
