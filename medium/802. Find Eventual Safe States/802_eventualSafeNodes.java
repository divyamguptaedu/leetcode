"
Performance:
Runtime: 9 ms, faster than 60.22% of Java online submissions for Find Eventual Safe States.
Memory Usage: 64.7 MB, less than 82.83% of Java online submissions for Find Eventual Safe States.
"

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] safe = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++){
            if (helper(graph, safe, i)) {
               result.add(i);
            }
        }
        return result;

    }

    public boolean helper(int[][] graph, int[] safe, int current) {
        if (safe[current] == 2) {
            return true;
        }
        if (safe[current] == 1) {
            return false;
        }
        safe[current] = 1;
        int[] edge = graph[current];
        for (int i = 0; i < edge.length; i++) {
            if (!helper(graph, safe, edge[i])) {
                return false;
            }
        }
        safe[current] = 2;
        return true;
    }
}