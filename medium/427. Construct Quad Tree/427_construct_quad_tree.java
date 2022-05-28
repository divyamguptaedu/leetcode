"""
Performance:
Runtime: 2 ms, faster than 56.23% of Java online submissions for Construct Quad Tree.
Memory Usage: 49.1 MB, less than 16.12% of Java online submissions for Construct Quad Tree.
"""

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
       return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
    
    private Node helper(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart == rowEnd) {
            return new  Node(grid[rowStart][colStart] == 1, true);
        }
        
        int length = rowEnd - rowStart + 1;
        int midRow = rowStart + length / 2;
        int midCol = colStart + length / 2;
        Node topLeft = helper(grid, rowStart, midRow - 1, colStart, midCol - 1);
        Node topRight = helper(grid,rowStart, midRow - 1, midCol, colEnd);
        Node bottomLeft = helper(grid,  midRow, rowEnd, colStart, midCol - 1);
        Node bottomRight = helper(grid,  midRow, rowEnd,  midCol, colEnd);
        Node[] children = new Node[]{topLeft, topRight, bottomLeft, bottomRight};
        boolean val = topLeft.val;
        for (Node child: children) {
            if (!child.isLeaf || child.val != val) {
                return new Node(val, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
        
        return new  Node(val, true);
    }
}