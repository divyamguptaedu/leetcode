/*
You are given a binary search tree of integers, and a range  [low, high], please return the node which is the median for all the nodes inside the range

Input: binary search tree, and range [low, high]

```
            6
          /   \
         4     8
        / \   / \
      3   5 7   9
      /
     2
```

Input: [3, 5] => 4

Input: [0, 1] => NULL

Input: [10, 11] => NULL

Input: [6, 4]   => NULL

Input: [2, 8]   => 4 or 5


Approach:
1. If low >= high, return null
2. Inorder traversal to get nodes in range given.
3. Find the middle node return value

Edge case:
1. Empty tree
2. Single node
3. Skewed
4. No value in range present
5. Even number of nodes in range, odd number of nodes in range
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class RangeMedianBST {
    static List<Node> nodesInRange;
    public static Node findMedian(Node root, int[] range) {
        if (root == null || range.length != 2 || range[0] > range[1]) {
            return null;
        }

        nodesInRange = new ArrayList<>();
        dfs(root, range); //Inorder traversal to populate nodesInRange

        int size = nodesInRange.size();
        if (size != 0) {
            int middleIndex = size / 2;
            return nodesInRange.get(middleIndex);
        } else {
            return null;
        }
    }

    private static void dfs(Node current, int[] range) {
        if (current == null) {
            return;
        }
        dfs(current.left, range);
        if (current.val >= range[0] && current.val <= range[1]) {
            nodesInRange.add(current);
        }
        dfs(current.right, range);
    }
}

class RangeMedianBSTTest {
    @Test
    void emptyTreeTest() {
        Node result = RangeMedianBST.findMedian(null, new int[] {0, 0});
        assertNull(result);
    }

    @Test
    void singleTreeTest() {
        Node root = new Node(1);
        Node result = RangeMedianBST.findMedian(root, new int[] {0, 2});
        assertEquals(root, result);
    }

    @Test
    void singleTreeTest2() {
        Node root = new Node(1);
        Node result = RangeMedianBST.findMedian(root, new int[] {2, 2});
        assertNull(result);
    }

    @Test
    void skewedTreeTest() {
        Node root = new Node(3);
        root.left = new Node(2);
        root.left.left = new Node(1);
        Node result = RangeMedianBST.findMedian(root, new int[] {2, 2});
        assertEquals(root.left, result);
    }

    @Test
    void evenNodesInRangeTest() {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        Node result = RangeMedianBST.findMedian(root, new int[] {0, 10});
        assertEquals(root, result);
    }

    @Test
    void generalTest() {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.left.left = new Node(2);
        Node result = RangeMedianBST.findMedian(root, new int[] {3, 5});
        assertEquals(root.left, result);

        result = RangeMedianBST.findMedian(root, new int[] {0, 1});
        assertNull(result);

        result = RangeMedianBST.findMedian(root, new int[] {10, 11});
        assertNull(result);

        result = RangeMedianBST.findMedian(root, new int[] {6, 4});
        assertNull(result);

        result = RangeMedianBST.findMedian(root, new int[] {2, 8});
        assertEquals(root.left.right, result);

    }
}