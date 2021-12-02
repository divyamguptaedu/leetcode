"""
Performance:
Runtime: 177 ms, faster than 50.03% of Java online submissions for Critical Connections in a Network.
Memory Usage: 138.7 MB, less than 48.01% of Java online submissions for Critical Connections in a Network.
"""
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new LinkedList<>();
        int[] array = new int[n];
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n;i++) {
            graph.add(new HashSet<>());
            array[i] = -1;
        }
        for (List<Integer> connection: connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        helper(0, 0, graph, 0, result, array);
        return result;

    }

    private int helper(int node, int parent, List<Set<Integer>> graph, int level, List<List<Integer>> result, int[] array) {
        array[node] = level;
        for (int child: graph.get(node)) {
            if (child == parent) {
                continue;
            }
            if (array[child] == -1) {
                array[node] = Math.min(helper(child, node, graph, level + 1, result, array), array[node]);
            } else {
                array[node] = Math.min(array[node], array[child]);
            }
        }
        if (node != 0 && array[node] == level) {
            result.add(Arrays.asList(new Integer[]{node, parent}));
        }
        return array[node];
    }
}