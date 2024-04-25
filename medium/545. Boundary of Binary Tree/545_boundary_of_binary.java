//Approached the problem as four tasks. 
//Made a result list, added the root, then added the left boundary while defining the rules. 
//Then added the leaves, computed using DFS, 
//and finally the right boundary nodes using a stack to get the reverse order.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //TIme: O(n)
 //Space: O(n)
public class Solution {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //add root
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
        //add left boundary
        TreeNode leftBoundaryNode = root.left;
        while (leftBoundaryNode != null) {
            if (leftBoundaryNode.left != null || leftBoundaryNode.right != null) {
                result.add(leftBoundaryNode.val);
            }
            if (leftBoundaryNode.left != null) {
                leftBoundaryNode = leftBoundaryNode.left;
            } else {
                leftBoundaryNode = leftBoundaryNode.right;
            }

        }
        //add leaves
        addLeaves(result, root);

        //add right boundary
        Stack<Integer> stack = new Stack<>(); //for reverse order
        TreeNode rightBoundaryNode = root.right;
        while (rightBoundaryNode != null) {
            if (rightBoundaryNode.left != null || rightBoundaryNode.right != null) {
                stack.push(rightBoundaryNode.val);
            }
            if (rightBoundaryNode.right != null) {
                rightBoundaryNode = rightBoundaryNode.right;
            } else {
                rightBoundaryNode = rightBoundaryNode.left;
            }
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public void addLeaves(List<Integer> result, TreeNode node) {
        if (node.left == null && node.right == null) {
            result.add(node.val);
        } else {
            if (node.left != null) {
                addLeaves(result, node.left);
            }
            if (node.right != null) {
                addLeaves(result, node.right);
            }
        }
    }
}