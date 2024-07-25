//I traversed the tree using DFS to find paths from the root to both start and
//destination nodes. I then compared the paths to find the common part,
//which corresponds to the shared ancestor.
//For the final path, I added 'U' moves for each step back to the common ancestor
//and appended the remaining path to the destination.
//This involved reversing the path from the destination to the common ancestor.

//Time: n
//Space: n

//Example input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//pathFromStart: LL
//pathFromEnd: LR (will be reversed later while forming the output)
//common = 0
//output UURL

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
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // StringBuilders to hold paths from root to start and destination nodes
        StringBuilder pathFromStart = new StringBuilder();
        StringBuilder pathFromEnd = new StringBuilder();
        
        // Find paths using DFS
        findPath(root, pathFromStart, startValue);
        findPath(root, pathFromEnd, destValue);
        
        int startLength = pathFromStart.length();
        int endLength = pathFromEnd.length();
        int commonAncestorSteps = 0;
        
        // Find the length of the common path part (common ancestor)
        while (startLength > 0 && endLength > 0 && pathFromStart.charAt(startLength - 1) == pathFromEnd.charAt(endLength - 1)) {
            commonAncestorSteps++;
            startLength--;
            endLength--;
        }
        
        // Generate the path from the start node to the common ancestor
        String upSteps = "U".repeat(pathFromStart.length() - commonAncestorSteps);
        // Generate the path from the common ancestor to the destination node
        String downSteps = pathFromEnd.reverse().toString().substring(commonAncestorSteps);
        
        // Combine both paths to get the final path from start to destination
        return upSteps + downSteps;
    }

    private boolean findPath(TreeNode currentNode, StringBuilder path, int targetValue) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.val == targetValue) {
            return true;
        }
        // Try to find the target in the left subtree
        if (findPath(currentNode.left, path, targetValue)) {
            path.append("L");
        // If not found in left, try in the right subtree
        } else if (findPath(currentNode.right, path, targetValue)) {
            path.append("R");
        }
        // Return true if the path is non-empty, meaning the target was found
        return path.length() > 0;
    }
}
//another solution

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
    TreeNode lca;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        recurseTree(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);
        StringBuilder directions = new StringBuilder();
        directions.append("U".repeat(pathToStart.length()));
        directions.append(pathToDest);
        return directions.toString();
    }

    private boolean recurseTree(TreeNode currentNode, int p, int q) {
        if (currentNode == null) {
            return false;
        }
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode.val == p || currentNode.val == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.lca = currentNode;
        }
        return (mid + left + right > 0);
    }

    private boolean findPath(TreeNode node, int nodeVal, StringBuilder sb) {
        if (node == null) {
            return false;
        }
        if (node.val == nodeVal) {
            return true;
        }
        sb.append("L");
        if (findPath(node.left, nodeVal, sb)) {
            return true;
        }
        sb.setLength(sb.length() - 1);
        sb.append("R");
        if (findPath(node.right, nodeVal, sb)) {
            return true;
        }
        sb.setLength(sb.length() - 1);
        return false;
    }
}