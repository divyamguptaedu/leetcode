/*
Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that the sum
of chosen nodes is maximum under a constraint that no two chosen nodes in the subset should be directly connected that is,
if we have taken a node in our sum then we can’t take any of its children in consideration and vice versa.

```
    4
   / \
  2   2
 / \    \
1   -5    3
      \
       7

4 + 1 + 3 + 7
3 + 7

Approach:
1. Use recursion to calculate two sums:
    1. One sum represents choosing the node, not the children
    2. Second sum represents choosing the children, not the node.

2. After dfs traversal, we will have two sums
3. Return the max of the two sums.
//Time: O(n)
//Space: O(n)

Expected: 13
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

class MaxSum {
    public static int getMaxSum(Node root) {
        int[] result = getMaxSumHelper(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] getMaxSumHelper(Node current) {
        if (current == null) return new int[2];

        int[] left = getMaxSumHelper(current.left);
        int[] right = getMaxSumHelper(current.right);

        int inludingNode = current.val + left[1] + right[1];
        int exludingNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {inludingNode, exludingNode};
    }
}

class MaxSumTest {
    @Test
    void generalTest() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(-5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(3);
        Integer result = MaxSum.getMaxSum(root);
        assertEquals(15, result);
    }
    @Test
    void generalTest2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        Integer result = MaxSum.getMaxSum(root);
        assertEquals(11, result);
    }
}


