class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Set<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int result = 0;

        if (n <= 1) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int temp = queue.remove();
                    visited[temp] = true;
                    for (int next : adjacencyList.get(temp)) {
                        if (!visited[next]) {
                            queue.add(next);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }
}