"
Performance:
Runtime: 51 ms, faster than 14.74% of Java online submissions for Find Duplicate Subtrees.
Memory Usage: 61.2 MB, less than 17.51% of Java online submissions for Find Duplicate Subtrees.
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Map<String,TreeNode> hashMap = new HashMap<>();
        getDuplicate(result, root, hashMap, false, false);
        return new ArrayList<>(result);
    }
    
    public String getDuplicate(Set<TreeNode> result, TreeNode root, Map<String,TreeNode> hashMap, boolean left, boolean right) {
        if (root == null && left) {
            return "leftNull";
        }
        if (root == null && right) {
            return "rightNull";
        }
        if (root == null)
            return "null";
        int value = root.val;
        String leftString =  getDuplicate(result, root.left, hashMap, true, false);
        String rightString =  getDuplicate(result, root.right, hashMap, false, true);
        String combined = leftString + value + rightString;
        if (hashMap.containsKey(combined)) {
            result.add(hashMap.get(combined));
        } else {
            hashMap.put(combined, root);
        }
        return combined;
    }
}