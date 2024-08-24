import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/*
Find the longest path in the directory tree string.

```
Given an input like "a\n\tb\n\t\tc\n\t\td\n\te\n\t\tf\n\t\t\tcow\b"

Stack: a, e, f, cow


Which represents a directory tree like this:

a
  b
    c
    d
  e
    f
      cow

Find the length of the longest absolute file path

The longest in the tree above is:

"a/e/f/cow" which is of length 9

The answer is 9.

```

Edge Cases:
1. Skewed directory
2. Single folder
3. No folder
4. Multiple roots

Approach:
Step 1: Build the tree
    1. Start with a stack, add the root
    2. Start traversing
Step 2: Traverse in DFS manner to find the longest root to leaf path. Definition of longest: sum of length of all nodes' values + buffer.
Buffer: add one for every new level to the count
 */

class Node {
    String val;
    List<Node> children;

    public Node (String val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Node (String val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class Main {
    // Builds the tree from the input string
    public static List<Node> buildTree(String input) {
        String[] lines = input.split("\n");
        Stack<Node> nodeStack = new Stack<>();
        List<Node> result = new ArrayList<>();

        for (String line : lines) {
            int depth = line.lastIndexOf("\t") + 1;
            String nodeName = line.substring(depth);
            Node currentNode = new Node(nodeName);

            if (depth == 0) {
                result.add(currentNode);
                nodeStack.clear(); // Clear the stack for new root
                nodeStack.add(currentNode);
            } else {
                while (nodeStack.size() > depth) {
                    nodeStack.pop();
                }
                nodeStack.peek().children.add(currentNode);
                nodeStack.add(currentNode);
            }
        }

        return result;
    }

    private int maxLength;

    // Finds the longest root-to-leaf path length
    public int findLongestPath(List<Node> roots) {
        maxLength = 0;
        for (Node root : roots) {
            dfs(root, root.val.length());
        }
        return maxLength;
    }

    // DFS traversal to find the longest path
    private void dfs(Node node, int currentLength) {
        if (node.children.isEmpty()) {
            maxLength = Math.max(maxLength, currentLength);
            return;
        }

        for (Node child : node.children) {
            dfs(child, currentLength + child.val.length() + 1); // +1 for the "/"
        }
    }

    @Test
    public void testFindLongestPath() {
        String input = "a\n\tb\n\t\tc\n\t\td\n\te\n\t\tf\n\t\t\tcow";
        List<Node> tree = buildTree(input);
        int result = findLongestPath(tree);
        assertEquals(9, result); // "a/e/f/cow" -> length 9
    }

    @Test
    public void testSkewedDirectory() {
        String input = "a\n\tb\n\t\tc";
        List<Node> tree = buildTree(input);
        int result = findLongestPath(tree);
        assertEquals(5, result); // "a/b/c" -> length 5
    }

    @Test
    public void testSingleFolder() {
        String input = "a";
        List<Node> tree = buildTree(input);
        int result = findLongestPath(tree);
        assertEquals(1, result); // "a" -> length 1
    }

    @Test
    public void testNoFolder() {
        String input = "";
        List<Node> tree = buildTree(input);
        int result = findLongestPath(tree);
        assertEquals(0, result); // No folder
    }

    @Test
    public void testMultipleRoots() {
        String input = "a\n\tb\n\t\tc\nx\n\ty\n\t\tz";
        List<Node> tree = buildTree(input);
        int result = findLongestPath(tree);
        assertEquals(5, result); // Both "a/b/c" and "x/y/z" -> length 5
    }
}