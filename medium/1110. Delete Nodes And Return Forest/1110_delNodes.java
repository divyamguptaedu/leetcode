//Added the nodes to be deleted in a hashSet to make 'contains' an O(1) operation. 
//Did a DFS traversal of the tree which just checks if the currentNode is in the hashset, 
//if yes, then I check if there are left and right child nodes present, 
//if yes, they are added to the root list and the main node is changed to null to make it as deleted. 
//Finally in the end, the root is checked if it is null, 
//if not, it is added to the root list as well and returned.
//Time: O(n)
//Space: O(n)

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
    List<TreeNode> result = new ArrayList();
    Set<Integer> set = new HashSet();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) { //adding the nodes in to_delete to a set to make the contains operation O(1)
            set.add(i);
        }
        root = helper(root);
        if (root != null) {
            result.add(root);
        }
        return result;
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = helper(node.left);
        node.right = helper(node.right);
        if (set.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left); //child node of the deleted node will become a root
            }
            if (node.right != null) {
                result.add(node.right); //child node of the deleted node will become a root
            }
            node = null;
        }
        return node;
    }
}