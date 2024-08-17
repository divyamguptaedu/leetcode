import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/*
Given a string that contains a ternary expression which may be nested.
The task is to convert the given ternary expression to a binary tree and return the root.

**Input:** "a?b:c"
**Output:**
  a
 / \
b   c

 */

class TreeNode {
    char val;
    TreeNode left, right;

    TreeNode(char val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class TernaryExpressionToBinaryTree {

    public static TreeNode convert(String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        return convertHelper(expression.toCharArray(), 0);
    }

    private static TreeNode convertHelper(char[] expression, int i) {
        if (i >= expression.length) {
            return null;
        }

        // Create the current node with the character at index i
        TreeNode root = new TreeNode(expression[i]);
        i++;

        // If the current character is '?', then process the left child
        if (i < expression.length && expression[i] == '?') {
            root.left = convertHelper(expression, i + 1);
        } else if (i < expression.length && expression[i] == ':') {
            // Otherwise, process the right child
            root.right = convertHelper(expression, i + 1);
        }

        return root;
    }
}

//class TernaryExpressionToBinaryTree {
//
//    public static TreeNode convert(String input) {
//        char[] expression = input.toCharArray();
//        if (expression == null || expression.length == 0) {
//            return null;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode root = new TreeNode(expression[0]);
//        stack.push(root);
//
//        for (int i = 1; i < expression.length; i++) {
//            char currentChar = expression[i];
//
//            if (currentChar == '?') {
//                TreeNode node = new TreeNode(expression[i + 1]);
//                stack.peek().left = node;
//                stack.push(node);
//                i++;  // Skip the next character as it has been processed
//            } else if (currentChar == ':') {
//                TreeNode node = new TreeNode(expression[i + 1]);
//                while (!stack.isEmpty() && stack.peek().right != null) {
//                    stack.pop();  // Pop until you find a node without a right child
//                }
//                if (!stack.isEmpty()) {
//                    stack.peek().right = node;
//                }
//                stack.push(node);
//                i++;  // Skip the next character as it has been processed
//            }
//        }
//
//        return root;
//    }
//}


class TernaryExpressionToBinaryTreeTest {

    @Test
    void testEmptyString() {
        assertNull(TernaryExpressionToBinaryTree.convert(""));
    }

    @Test
    void testSingleCharacter() {
        TreeNode root = TernaryExpressionToBinaryTree.convert("a");
        assertNotNull(root);
        assertEquals('a', root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testNoTernaryOperators() {
        TreeNode root = TernaryExpressionToBinaryTree.convert("abc");
        assertNotNull(root);
        assertEquals('a', root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testNestedTernaryExpressions() {
        TreeNode root = TernaryExpressionToBinaryTree.convert("a?b?c:d:e");
        assertNotNull(root);
        assertEquals('a', root.val);
        assertEquals('b', root.left.val);
        assertEquals('e', root.right.val);
        assertEquals('c', root.left.left.val);
        assertEquals('d', root.left.right.val);
    }
}