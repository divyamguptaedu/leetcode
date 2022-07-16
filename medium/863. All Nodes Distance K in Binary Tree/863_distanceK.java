"
Performance:
Runtime: 15 ms, faster than 70.09% of Java online submissions for All Nodes Distance K in Binary Tree.
Memory Usage: 43.1 MB, less than 56.70% of Java online submissions for All Nodes Distance K in Binary Tree.
"

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result;
    private int estimate = -1;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        if (k == 0) {
            return Arrays.asList(target.val);
        }
        helper(root, estimate, target.val, k);
        return result;
    }

    private int helper(TreeNode node, int distance, final int target, final int k) {
        if (node == null) {
            return estimate;
        }
        if (distance == estimate) {
            if (node.val == target) {
                helper(node.left, 1, target, k);
                helper(node.right, 1, target, k);
                return 0;
            }
            int leftDistance = helper(node.left, estimate, target, k);
            if (leftDistance != estimate) {
                distance = leftDistance + 1;
                if (distance == k) {
                    result.add(node.val);
                } else if (distance < k) {
                    helper(node.right, distance + 1, target, k);
                }
                return distance;
            }
            final int rightDistance = helper(node.right, estimate, target, k);
            if (rightDistance != estimate) {
                distance = rightDistance + 1;
                if (distance == k) {
                    result.add(node.val);
                } else if (distance < k) {
                    helper(node.left, distance + 1, target, k);
                }
                return distance;
            }
            return estimate;
        } else {
            if (distance == k) {
                result.add(node.val);
            } else {
                helper(node.left, distance + 1, target, k);
                helper(node.right, distance + 1, target, k);
            }
            return distance;            
        }
    }
}