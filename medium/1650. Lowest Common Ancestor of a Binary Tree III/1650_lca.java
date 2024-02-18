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

//another solution

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
        HashSet<Node> set = new HashSet<>();
        set.add(p);
        if (set.contains(q)) {
            return p;
        }
        set.add(q);
        while (p != null && q != null) {
            p = p.parent;
            q = q.parent;
            if (set.contains(p)) {
                return p;
            } else {
                set.add(p);
            }
            if(set.contains(q)) {
                return q;
            } else {
                set.add(q);
            }
        }
        while (p != null) {
            p = p.parent;
            if (set.contains(p)) {
                return p;
            }
        }
        while (q != null) {
            q = q.parent;
            if (set.contains(q)) {
                return q;
            }
        }
        return null;
    }
}