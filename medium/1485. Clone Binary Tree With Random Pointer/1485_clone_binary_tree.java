/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

/*
1. Traverse the tree starting from the root.
2. Create a copy of each node and put it inside a hashmap.
3. Do the same for left, right, and random nodes of the root.
4. Return the value in the map for the original root.
*/

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node, NodeCopy> valueMap = new HashMap<>();
        helper(root, valueMap);
        return valueMap.get(root);
    }
    
    private NodeCopy helper(Node root, Map<Node, NodeCopy> valueMap) {
        if (root == null) {
            return null;
        }
        if (valueMap.containsKey(root)) {
            return valueMap.get(root);
        }
        NodeCopy temp = new NodeCopy(root.val);
        valueMap.put(root, temp);
        temp.left = helper(root.left, valueMap);
        temp.right = helper(root.right, valueMap);
        temp.random = helper(root.random, valueMap);
        return temp;
    }
    
}