import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/*
K-th Ancestor of a Node in Binary Tree (Iterative)

    5
   / \
  3   4
 / \ / \
 1  27  8


 Test cases:
 1. General
 2. Ancestor not present
 3. K = 0;
 4. target node is root
 5. skewed

 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class QuestionTwo {
    public static TreeNode kthAncestor(TreeNode root, TreeNode targetNode, int k) {
        if (root == null || k < 0) {
            return null;
        }

        if (k == 0) {
            return targetNode;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        List<TreeNode> pathList = new ArrayList<>();

        while (!nodeStack.isEmpty() || current != null) {
            while (current != null) {
                nodeStack.add(current);
                pathList.add(current);
                current = current.left;
            }

            current = nodeStack.peek();

            if (current == targetNode) {
                int index = pathList.size() - k - 1;
                if (index >= 0) {
                    return pathList.get(index);
                } else {
                    return null;
                }
            }

            if (current.right != null && lastVisited != current.right) {
                current = current.right;
            } else {
                //Backtracking part
                lastVisited = nodeStack.pop();
                pathList.remove(pathList.size() - 1);
                current = null;
            }
        }

        return null;
    }
}


/*
    5
   / \
  3   4
 / \ / \
 1  27  8


 Test cases:
 1. General
 2. Ancestor not present
 3. K = 0;
 4. target node is root
 5. skewed

 */
class QuestionTwoTest {
    @Test
    public void kthAncestorTestOne() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        TreeNode result = QuestionTwo.kthAncestor(root, root.right.right, 2);
        assertEquals(result, root);

        result = QuestionTwo.kthAncestor(root, root.right.right, 1);
        assertEquals(result, root.right);

        result = QuestionTwo.kthAncestor(root, root.right.right, 10);
        assertNull(result);

        result = QuestionTwo.kthAncestor(root, root.right.right, 0);
        assertEquals(result, root.right.right);

        result = QuestionTwo.kthAncestor(root, root, 0);
        assertEquals(result, root);

        result = QuestionTwo.kthAncestor(root, root, 1);
        assertNull(result);
    }
}