"
Performance:
Runtime: 22 ms, faster than 42.41% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
Memory Usage: 40 MB, less than 42.10% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
"

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> parents = new HashSet<>();
        Node temp = p;
        while (temp != null) {
            parents.add(temp);
            temp = temp.parent;
        }
        temp = q;
        while (temp != null) {
            if (parents.contains(temp)) {
                break;
            } else {
                temp = temp.parent;
            }
        }
        return temp;
    }
}