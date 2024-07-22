//Considered each subtree as an individual tree. 
//Defined rules. Recursed on the list whenever '(' is found. 
//Left for the first time, right for the second time. 
//Also defined a getNum function to convert the set of characters to a number.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
//     public TreeNode str2tree(String s) {
//         if (s.isEmpty()) {
//             return null;
//         }
//         String[] threeStrings = getThreeStrings(s);
//         String nodeValue = threeStrings[0];
//         String leftValue = threeStrings[1];
//         String rightValue = threeStrings[2];
//         return new TreeNode(Integer.parseInt(nodeValue),
//                 leftValue.isEmpty() ? null : str2tree(leftValue),
//                 rightValue.isEmpty() ? null : str2tree(rightValue));
//     }

//     private String[] getThreeStrings(String s) {
//         if (s.isEmpty()) {
//             return null;
//         }
//         String nodeValue = "";
//         String leftValue = "";
//         String rightValue = "";
//         int index = 0;
//         while (index < s.length() && s.charAt(index) != '(') {
//             nodeValue += s.charAt(index);
//             index++;
//         }
//         int openParenthesis = 1;
//         index++;
//         while (index < s.length() && openParenthesis != 0) {
//             if (s.charAt(index) == ')' && openParenthesis == 1) {
//                 openParenthesis--;
//             } else {
//                 if (s.charAt(index) == '(') {
//                     openParenthesis++;
//                 }
//                 if (s.charAt(index) == ')') {
//                     openParenthesis--;
//                 }
//                 leftValue += s.charAt(index);
//             }
//             index++;
//         }
//         openParenthesis = 1;
//         index++;
//         while (index < s.length() && openParenthesis != 0) {
//             if (s.charAt(index) == ')' && openParenthesis == 1) {
//                 openParenthesis--;
//             } else {
//                 if (s.charAt(index) == '(') {
//                     openParenthesis++;
//                 }
//                 if (s.charAt(index) == ')') {
//                     openParenthesis--;
//                 }
//                 rightValue += s.charAt(index);
//             }
//             index++;
//         }
//         String[] threeStrings = new String[3];
//         threeStrings[0] = nodeValue;
//         threeStrings[1] = leftValue;
//         threeStrings[2] = rightValue;
//         return threeStrings;
//     }
// }

class Solution {
    private int i;

    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }
        i = 0;
        return buildTree(s);
    }

    private TreeNode buildTree(String s) {
        if (i >= s.length()) {
            return null;
        }
        int val = 0;
        boolean negative = false;
        if (s.charAt(i) == '-') {
            negative = true;
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            val = val * 10 + s.charAt(i) - '0';
            i++;
        }
        TreeNode newNode = new TreeNode(negative ? -val : val);
        if (i >= s.length() || s.charAt(i) == ')') {
            i++;
            return newNode;
        }
        if (s.charAt(i) == '(') {
            i++;
            newNode.left = buildTree(s);
        }
        if (i >= s.length() || s.charAt(i) == ')') {
            i++;
            return newNode;
        }
        if (s.charAt(i) == '(') {
            i++;
            newNode.right = buildTree(s);
        }
        if (i < s.length() && s.charAt(i) == ')') {
            i++;
        }
        return newNode;
    }
}