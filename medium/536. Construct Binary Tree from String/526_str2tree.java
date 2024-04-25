//Considered each subtree as an individual tree. 
//Defined rules. Recursed on the list whenever '(' is found. 
//Left for the first time, right for the second time. 
//Also defined a getNum function to convert the set of characters to a number.
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

// Time: O(n)
// Space: O(h) h is the height of the tree
class Solution {
    int index = 0;

    public TreeNode str2tree(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        TreeNode root = new TreeNode();
        return buildTree(root, s);
    }
    
    private TreeNode buildTree(TreeNode root, String s) {
        if (index >= s.length()) {
            return root;
        }        
        if (Character.isDigit(s.charAt(index))) {
            root = new TreeNode(getNum(s));
        }
        if (index < s.length() && s.charAt(index) == '-') {
            index++;
            root = new TreeNode(getNum(s));
            root.val *= -1;
        }
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            root.left = str2tree(s);
            if (index < s.length() && s.charAt(index) == '(') {
                index++;
                root.right = str2tree(s);
            }
        }
        
        if (index < s.length() && s.charAt(index) == ')') {
            index++;
        }
        return root;
    }

    private int getNum(String s) {
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + s.charAt(index) - '0';
            index++;
        }
        return num;
    }
}