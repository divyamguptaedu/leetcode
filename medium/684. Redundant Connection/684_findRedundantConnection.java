"
Performance:
Runtime: 10 ms, faster than 98.82% of Java online submissions for Redundant Connection.
Memory Usage: 50.3 MB, less than 68.52% of Java online submissions for Redundant Connection.
"

class Solution {
    boolean[] visited;
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            hashMap.put(i + 1, new ArrayList<>());
        }

        int[] result = new int[2];
        for (int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            visited = new boolean[edges.length + 1];
            if (!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty() && helper(edge[0], edge[1], hashMap)) {
                return edge;
            }
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }
        return result;
    }
    public boolean helper(int edge, int target, HashMap<Integer, List<Integer>> hashMap) {
        if (edge == target){
            return true;
        }
        visited[edge] = true;
        List<Integer> edgeList = hashMap.get(edge);

        for (Integer next: edgeList) {
            if (!visited[next]) {
                if (helper(next, target, hashMap)) {
                    return true;
                }
            }
        }
        return false;
    }
} 

// other way

class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return new int[]{-1,-1};
    }
    
    private int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
    
    private void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        
        if (iRoot != jRoot) {
            parent[jRoot] = iRoot;
        }
    }
}