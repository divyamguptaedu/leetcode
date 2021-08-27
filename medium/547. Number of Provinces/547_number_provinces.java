class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < isConnected.length; i++)
            if (helper(isConnected, visited, i)) {
                count++;
            }
        return count;
    }
    
    // DFS
    private boolean helper(int[][] isConnected, Set<Integer> visited, int node) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int i = 0; i < isConnected[node].length; i++)
            if (isConnected[node][i] == 1) {
                helper(isConnected, visited, i);
            }
        return true;
    }
}