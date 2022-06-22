"
Performance:
Runtime: 18 ms, faster than 7.12% of Java online submissions for Most Frequent Subtree Sum.
Memory Usage: 45.7 MB, less than 66.52% of Java online submissions for Most Frequent Subtree Sum.
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
    int maximum = -1;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        helper(root, hashMap); 
        List<Integer> result = new ArrayList<>(); 
        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) == maximum) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    public void helper(TreeNode root,Map<Integer,Integer> hashMap){
        if (root == null) {
            return;
        }
        helper(root.left, hashMap);
        helper(root.right, hashMap); 
        int sum = root.val;
        if (root.left != null) {
            sum+= root.left.val;
        }
        if (root.right != null) {
            sum+= root.right.val;
        }
        hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        maximum = Math.max(maximum, hashMap.get(sum));
        root.val = sum;
    }
}