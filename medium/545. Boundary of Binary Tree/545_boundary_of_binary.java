"
Performance:
Runtime: 3 ms, faster than 8.10% of Java online submissions for Boundary of Binary Tree.
Memory Usage: 38.8 MB, less than 99.33% of Java online submissions for Boundary of Binary Tree.
"

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
class Solution {

    Map<TreeNode, Boolean> leftMap = new HashMap<>();
    Map<TreeNode, Boolean> rightMap = new HashMap<>();
    Map<TreeNode, Boolean> rootMap = new HashMap<>();
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        Deque<Integer> rightBoundaryStack = new ArrayDeque<>();
        boundary.add(root.val);
        
        isRoot.put(root, true);
        if (root.left != null) {
            leftMap.put(root.left, true);
        }
        if (root.right != null) {
            rightMap.put(root.right, true);
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.removeFirst();
            
            // add to results and do accounting for children
            boolean isLeaf = curr.right == null && curr.left == null;
            boolean isLeft = leftMap.getOrDefault(curr, false);
            boolean isRight = rightMap.getOrDefault(curr, false);
            if (isLeaf && !rootMap.getOrDefault(curr, false)) {
                boundary.add(curr.val);
            } else if (isLeft) {
                boundary.add(curr.val);
                if (curr.left != null) {
                    leftMap.put(curr.left, true);
                } else if (curr.right != null) {
                    leftMap.put(curr.right, true);
                }
            } else if (isRight) {
                rightBoundaryStack.addFirst(curr.val);
                if (curr.right != null) {
                    rightMap.put(curr.right, true);
                } else if (curr.left != null) {
                    rightMap.put(curr.left, true);
                }
            }
            
            if (curr.right != null) {
                stack.addFirst(curr.right);
            }
            if (curr.left != null) {
                stack.addFirst(curr.left);
            }
        }
        
        boundary.addAll(rightBoundaryStack);
        return boundary;
    }
}