class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] degrees = new int[n];
        for(int i = 0; i < edges.length; i++) {
            adj.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            adj.putIfAbsent(edges[i][1], new ArrayList<Integer>());
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int temp = queue.remove(); 
                List<Integer> neighborNodes = adj.get(temp);
                for (int node : neighborNodes) {
                    if (--degrees[node] == 1) {
                        queue.add(node);  
                    }
                adj.remove(temp);
            }
            }
            List<Integer> result = new ArrayList<>();
            for (Integer node : queue) {
                result.add(node);
            }
        }
        return result;
    }
}