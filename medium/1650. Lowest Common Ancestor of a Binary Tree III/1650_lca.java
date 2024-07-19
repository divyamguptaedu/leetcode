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

        Set<Integer> pAncestors = new HashSet<Integer>();
        Set<Integer> qAncestors = new HashSet<Integer>();

        pAncestors.add(p.val);
        qAncestors.add(q.val);

        while (p.parent != null || q.parent != null) {
            if (p.parent != null) {
                p = p.parent;
                pAncestors.add(p.val);
            }

            if (q.parent != null) {
                q = q.parent;
                qAncestors.add(q.val);
            }

            if (pAncestors.contains(q.val)) {
                return q;
            }

            if (qAncestors.contains(p.val)) {
                return p;
            }
        }

        return null;
    }
}