import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // In-order traversal using recursion: traverse left subtree, visit node, traverse right subtree.
    public List<Integer> inorderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        // If the node is null, return to the previous level.
        if (node == null) {
            return;
        }
        // Traverse the left subtree first.
        traverse(node.left);
        // Visit the node by adding its value to the result list.
        result.add(node.val);
        // Traverse the right subtree.
        traverse(node.right);
    }

    // In-order traversal using iteration: simulate the recursive process with a stack.
    public List<Integer> inorderIterative(TreeNode root) {
        result = new ArrayList<>();
        Stack<TreeNode> dfsStack = new Stack<>();
        TreeNode current = root;

        // Continue traversing until all nodes are visited.
        while (current != null || !dfsStack.isEmpty()) {
            if (current != null) {
                // Push all the left nodes onto the stack.
                dfsStack.push(current);
                current = current.left;
            } else {
                // Visit the node and then traverse the right subtree.
                current = dfsStack.pop();
                result.add(current.val);
                current = current.right;
            }
        }

        return result;
    }
}

// Pre-order traversal
class PreOrderTraversal {
    private List<Integer> result;

    // Pre-order traversal using recursion: visit node, traverse left subtree, traverse right subtree.
    public List<Integer> preOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        // If the node is null, return to the previous level.
        if (node == null) {
            return;
        }
        // Visit the node by adding its value to the result list.
        result.add(node.val);
        // Traverse the left subtree next.
        traverse(node.left);
        // Finally, traverse the right subtree.
        traverse(node.right);
    }

    // Pre-order traversal using iteration: simulate the recursive process with a stack.
    public List<Integer> preOrderIterative(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> dfsStack = new Stack<>();
        dfsStack.push(root);

        // Continue traversing until all nodes are visited.
        while (!dfsStack.isEmpty()) {
            TreeNode current = dfsStack.pop();
            // Visit the node by adding its value to the result list.
            result.add(current.val);
            // Push right child first so that left is processed next.
            if (current.right != null) {
                dfsStack.push(current.right);
            }
            if (current.left != null) {
                dfsStack.push(current.left);
            }
        }

        return result;
    }
}

// Post-order traversal
class PostOrderTraversal {
    private List<Integer> result;

    // Post-order traversal using recursion: traverse left subtree, traverse right subtree, visit node.
    public List<Integer> postOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        // If the node is null, return to the previous level.
        if (node == null) {
            return;
        }
        // Traverse the left subtree first.
        traverse(node.left);
        // Then, traverse the right subtree.
        traverse(node.right);
        // Visit the node by adding its value to the result list.
        result.add(node.val);
    }

    // Post-order traversal using iteration: simulate the recursive process with a stack.
    public List<Integer> postOrderIterative(TreeNode root) {
        result = new ArrayList<>();
        Stack<TreeNode> dfsStack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        // Continue traversing until all nodes are visited.
        while (current != null || !dfsStack.isEmpty()) {
            if (current != null) {
                // Push all the left nodes onto the stack.
                dfsStack.push(current);
                current = current.left;
            } else {
                TreeNode temp = dfsStack.peek();
                // Check if right subtree exists and has not been visited yet.
                if (temp.right != null && temp.right != lastVisited) {
                    current = temp.right;
                } else {
                    // Visit the node by adding its value to the result list.
                    temp = dfsStack.pop();
                    result.add(temp.val);
                    lastVisited = temp;
                }
            }
        }

        return result;
    }
}

class LevelOrderTraversal {
    private List<List<Integer>> result;

    // Level-order traversal using iteration: processes nodes level by level using a queue.
    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        result = new ArrayList<>();

        // Handle the edge case where the tree is empty.
        if (root == null) {
            return result;
        }

        // Initialize a queue to manage the nodes at each level.
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);

        // Continue processing nodes until all levels are covered.
        while (!levelQueue.isEmpty()) {
            // List to store the current level's node values.
            List<Integer> currLevel = new ArrayList<>();
            int currLevelSize = levelQueue.size();  // Number of nodes in the current level.

            // Process all nodes in the current level.
            for (int i = 0; i < currLevelSize; i++) {
                // Remove the node from the queue and add its value to the current level list.
                TreeNode currNode = levelQueue.poll();
                currLevel.add(currNode.val);

                // Add left and right children to the queue for the next level, if they exist.
                if (currNode.left != null) {
                    levelQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    levelQueue.add(currNode.right);
                }
            }

            // Add the current level list to the result list after all nodes at that level are processed.
            result.add(currLevel);
        }

        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        levelOrderRecursiveHelper(root, 0);
        return result;
    }

    private void levelOrderRecursiveHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // If the current level is not yet in the result, add it
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to its level list
        result.get(level).add(node.val);

        // Recursively call left and right children for the next level
        levelOrderRecursiveHelper(node.left, level + 1);
        levelOrderRecursiveHelper(node.right, level + 1);
    }
}

// Class to store pairs of nodes and their column indexes
class Pair<K, V> {
    private final K key;
    private final V value;

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

// Vertical Order Traversal
class VerticalOrderTraversal {
    private List<List<Integer>> result;

    // Vertical-order traversal using level-order with position tracking.
    public List<List<Integer>> verticalOrderIterative(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // HashMap to maintain the order of columns from left to right
        HashMap<Integer, List<Integer>> columnTable = new HashMap<>();
        // Queue for BFS that holds pairs of TreeNode and its corresponding column index
        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair<>(root, 0));
        // Minimum column and maximum column variables to return result ordered by column
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        // Perform BFS
        while (!bfsQueue.isEmpty()) {
            Pair<TreeNode, Integer> pair = bfsQueue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            minCol = Math.min(minCol, column);
            maxCol = Math.max(maxCol, column);
            // Populate the column table with the node's value
            columnTable.putIfAbsent(column, new ArrayList<>());
            columnTable.get(column).add(node.val);

            // Traverse left and right children
            if (node.left != null) {
                bfsQueue.offer(new Pair<>(node.left, column - 1));
            }
            if (node.right != null) {
                bfsQueue.offer(new Pair<>(node.right, column + 1));
            }
        }

        // Add values to the result list from column table sorted by keys
        for (int i = minCol; i <= maxCol; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

    private Map<Integer, List<Integer>> columnTable;
    private int minCol;
    private int maxCol;

    public List<List<Integer>> verticalOrderRecursive(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        columnTable = new HashMap<>();
        minCol = 0;
        maxCol = 0;
        verticalOrderRecursiveHelper(root, 0);

        for (int i = minCol; i <= maxCol; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

    private void verticalOrderRecursiveHelper(TreeNode node, int column) {
        if (node == null) {
            return;
        }

        // Add the node's value to the column table
        columnTable.putIfAbsent(column, new ArrayList<>());
        columnTable.get(column).add(node.val);

        // Update the minimum and maximum column indexes
        minCol = Math.min(minCol, column);
        maxCol = Math.max(maxCol, column);

        // Recursively call left and right children with updated column indices
        verticalOrderRecursiveHelper(node.left,column - 1);
        verticalOrderRecursiveHelper(node.right,column + 1);
    }
}

class TraversalTests {
    TreeNode regularTreeRoot;
    TreeNode singleNodeRoot;
    TreeNode emptyRoot;
    TreeNode leftSkewedRoot;
    TreeNode rightSkewedRoot;

    // Setup different edge case trees
    @BeforeEach
    private void setup() {
        // Regular tree
        //         8
        //       /   \
        //      3    10
        //    /   \    \
        //    1   6    14
        //       / \  /
        //      4  7 13
        regularTreeRoot = new TreeNode(8);
        regularTreeRoot.left = new TreeNode(3);
        regularTreeRoot.right = new TreeNode(10);
        regularTreeRoot.left.left = new TreeNode(1);
        regularTreeRoot.left.right = new TreeNode(6);
        regularTreeRoot.right.right = new TreeNode(14);
        regularTreeRoot.left.right.left = new TreeNode(4);
        regularTreeRoot.left.right.right = new TreeNode(7);
        regularTreeRoot.right.right.left = new TreeNode(13);

        // Tree with a single node
        singleNodeRoot = new TreeNode(5);

        // Empty tree
        emptyRoot = null;

        // Left-skewed tree (all nodes only have a left child)
        //    4
        //   /
        //  3
        // /
        // 2
        // /
        // 1
        leftSkewedRoot = new TreeNode(4);
        leftSkewedRoot.left = new TreeNode(3);
        leftSkewedRoot.left.left = new TreeNode(2);
        leftSkewedRoot.left.left.left = new TreeNode(1);

        // Right-skewed tree (all nodes only have a right child)
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        rightSkewedRoot = new TreeNode(1);
        rightSkewedRoot.right = new TreeNode(2);
        rightSkewedRoot.right.right = new TreeNode(3);
        rightSkewedRoot.right.right.right = new TreeNode(4);
    }

    // InOrder Traversal Tests
    @Test
    public void inorderTest() {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        // Regular tree
        assertEquals(List.of(1, 3, 4, 6, 7, 8, 10, 13, 14), inOrderTraversal.inorderRecursive(regularTreeRoot));
        assertEquals(List.of(1, 3, 4, 6, 7, 8, 10, 13, 14), inOrderTraversal.inorderIterative(regularTreeRoot));

        // Single node
        assertEquals(List.of(5), inOrderTraversal.inorderRecursive(singleNodeRoot));
        assertEquals(List.of(5), inOrderTraversal.inorderIterative(singleNodeRoot));

        // Empty tree
        assertEquals(Collections.emptyList(), inOrderTraversal.inorderRecursive(emptyRoot));
        assertEquals(Collections.emptyList(), inOrderTraversal.inorderIterative(emptyRoot));

        // Left-skewed tree
        assertEquals(List.of(1, 2, 3, 4), inOrderTraversal.inorderRecursive(leftSkewedRoot));
        assertEquals(List.of(1, 2, 3, 4), inOrderTraversal.inorderIterative(leftSkewedRoot));

        // Right-skewed tree
        assertEquals(List.of(1, 2, 3, 4), inOrderTraversal.inorderRecursive(rightSkewedRoot));
        assertEquals(List.of(1, 2, 3, 4), inOrderTraversal.inorderIterative(rightSkewedRoot));
    }

    // PreOrder Traversal Tests
    @Test
    public void preorderTest() {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

        // Regular tree
        assertEquals(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13), preOrderTraversal.preOrderRecursive(regularTreeRoot));
        assertEquals(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13), preOrderTraversal.preOrderIterative(regularTreeRoot));

        // Single node
        assertEquals(List.of(5), preOrderTraversal.preOrderRecursive(singleNodeRoot));
        assertEquals(List.of(5), preOrderTraversal.preOrderIterative(singleNodeRoot));

        // Empty tree
        assertEquals(Collections.emptyList(), preOrderTraversal.preOrderRecursive(emptyRoot));
        assertEquals(Collections.emptyList(), preOrderTraversal.preOrderIterative(emptyRoot));

        // Left-skewed tree
        assertEquals(List.of(4, 3, 2, 1), preOrderTraversal.preOrderRecursive(leftSkewedRoot));
        assertEquals(List.of(4, 3, 2, 1), preOrderTraversal.preOrderIterative(leftSkewedRoot));

        // Right-skewed tree
        assertEquals(List.of(1, 2, 3, 4), preOrderTraversal.preOrderRecursive(rightSkewedRoot));
        assertEquals(List.of(1, 2, 3, 4), preOrderTraversal.preOrderIterative(rightSkewedRoot));
    }

    // PostOrder Traversal Tests
    @Test
    public void postorderEdgeCasesTest() {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();

        // Regular tree
        assertEquals(List.of(1, 4, 7, 6, 3, 13, 14, 10, 8), postOrderTraversal.postOrderRecursive(regularTreeRoot));
        assertEquals(List.of(1, 4, 7, 6, 3, 13, 14, 10, 8), postOrderTraversal.postOrderIterative(regularTreeRoot));

        // Single node
        assertEquals(List.of(5), postOrderTraversal.postOrderRecursive(singleNodeRoot));
        assertEquals(List.of(5), postOrderTraversal.postOrderIterative(singleNodeRoot));

        // Empty tree
        assertEquals(Collections.emptyList(), postOrderTraversal.postOrderRecursive(emptyRoot));
        assertEquals(Collections.emptyList(), postOrderTraversal.postOrderIterative(emptyRoot));

        // Left-skewed tree
        assertEquals(List.of(1, 2, 3, 4), postOrderTraversal.postOrderRecursive(leftSkewedRoot));
        assertEquals(List.of(1, 2, 3, 4), postOrderTraversal.postOrderIterative(leftSkewedRoot));

        // Right-skewed tree
        assertEquals(List.of(4, 3, 2, 1), postOrderTraversal.postOrderRecursive(rightSkewedRoot));
        assertEquals(List.of(4, 3, 2, 1), postOrderTraversal.postOrderIterative(rightSkewedRoot));
    }

    // LevelOrder Traversal Tests
    @Test
    public void levelorderEdgeCasesTest() {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        // Regular tree
        assertEquals(List.of(List.of(8), List.of(3, 10), List.of(1, 6, 14), List.of(4, 7, 13)),
                levelOrderTraversal.levelOrderIterative(regularTreeRoot));
        assertEquals(List.of(List.of(8), List.of(3, 10), List.of(1, 6, 14), List.of(4, 7, 13)),
                levelOrderTraversal.levelOrderRecursive(regularTreeRoot));

        // Single node
        assertEquals(List.of(List.of(5)), levelOrderTraversal.levelOrderIterative(singleNodeRoot));
        assertEquals(List.of(List.of(5)), levelOrderTraversal.levelOrderRecursive(singleNodeRoot));

        // Empty tree
        assertEquals(Collections.emptyList(), levelOrderTraversal.levelOrderIterative(emptyRoot));
        assertEquals(Collections.emptyList(), levelOrderTraversal.levelOrderRecursive(emptyRoot));

        // Left-skewed tree
        assertEquals(List.of(List.of(4), List.of(3), List.of(2), List.of(1)),
                levelOrderTraversal.levelOrderIterative(leftSkewedRoot));
        assertEquals(List.of(List.of(4), List.of(3), List.of(2), List.of(1)),
                levelOrderTraversal.levelOrderRecursive(leftSkewedRoot));

        // Right-skewed tree
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                levelOrderTraversal.levelOrderIterative(rightSkewedRoot));
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                levelOrderTraversal.levelOrderRecursive(rightSkewedRoot));
    }

    // VerticalOrder Traversal Tests
    @Test
    public void verticalOrderTest() {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();

        // Regular tree
        assertEquals(List.of(List.of(1), List.of(3, 4), List.of(8, 6), List.of(10, 7, 13), List.of(14)),
                verticalOrderTraversal.verticalOrderIterative(regularTreeRoot));
        assertEquals(List.of(List.of(1), List.of(3, 4), List.of(8, 6), List.of(7, 10, 13), List.of(14)),
                verticalOrderTraversal.verticalOrderRecursive(regularTreeRoot));

        // Single node
        assertEquals(List.of(List.of(5)), verticalOrderTraversal.verticalOrderIterative(singleNodeRoot));
        assertEquals(List.of(List.of(5)), verticalOrderTraversal.verticalOrderRecursive(singleNodeRoot));

        // Empty tree
        assertEquals(Collections.emptyList(), verticalOrderTraversal.verticalOrderIterative(emptyRoot));
        assertEquals(Collections.emptyList(), verticalOrderTraversal.verticalOrderRecursive(emptyRoot));

        // Left-skewed tree
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                verticalOrderTraversal.verticalOrderIterative(leftSkewedRoot));
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                verticalOrderTraversal.verticalOrderRecursive(leftSkewedRoot));

        // Right-skewed tree
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                verticalOrderTraversal.verticalOrderIterative(rightSkewedRoot));
        assertEquals(List.of(List.of(1), List.of(2), List.of(3), List.of(4)),
                verticalOrderTraversal.verticalOrderRecursive(rightSkewedRoot));
    }
}