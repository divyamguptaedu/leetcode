/**
Created an adjacency list and then just ran BFS on it till that K is reached. 
Populated the result list when the depth is equal to K.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time: O(n)
//Space: O(n)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>(); // get adjacency list
        buildGraph(root, null, graph);

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        queue.add(new Pair<>(target, 0));
        visited.add(target);
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int distance = pair.getValue();
            
            if (distance == K) {
                result.add(node.val);
            }
            
            if (distance > K) {
                break;
            }
            
            for (TreeNode neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Pair<>(neighbor, distance + 1));
                }
            }
        }
        
        return result;
    }
    
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) {
            return;
        }
        
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}