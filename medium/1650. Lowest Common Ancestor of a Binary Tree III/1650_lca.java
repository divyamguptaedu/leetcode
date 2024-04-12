/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pCopy = p;
        Node qCopy = q;
        while (pCopy != qCopy) {
            if (pCopy.parent == null) {
                pCopy = q;
            } else {
                pCopy = pCopy.parent;
            }
            if (qCopy.parent == null) {
                qCopy = p;
            } else {
                qCopy = qCopy.parent;
            }
        }
        return pCopy;
    }
}