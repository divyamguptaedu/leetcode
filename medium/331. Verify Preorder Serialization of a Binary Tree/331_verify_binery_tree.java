"""
Performance:
Runtime: 4 ms, faster than 47.95% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
Memory Usage: 40.8 MB, less than 11.99% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
"""

class Solution {
    private String[] array;
    private int index;
    public boolean isValidSerialization(String preorder) {
        array = preorder.split(",");
        index = 0;
        return traversal() && index == array.length;
    }
    
    public boolean traversal(){
        if (index >= array.length) {
            return false; 
        }
        String current = array[index++];
        if (current.equals("#")) {
            return true;
        }
        return traversal() && traversal();
    }
}