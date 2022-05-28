"""
Performance:
Runtime: 2 ms, faster than 92.67% of Java online submissions for N-ary Tree Level Order Traversal.
Memory Usage: 47.5 MB, less than 35.44% of Java online submissions for N-ary Tree Level Order Traversal.
"""

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(Node root, int level) {        
        if (root == null) {
            return;
        }
        List<Integer> answerList = level >= result.size() ? null : result.get(level);
        if(answerList == null) {
            answerList = new ArrayList<>();
            result.add(answerList);
        }
        answerList.add(root.val);
        if (root.children != null) {
            for(Node child: root.children) {
                helper(child, level + 1);
            }
        }
    }
}