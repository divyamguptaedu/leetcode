class Solution {
     List<Integer>[] graph;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        if (quiet == null || n == 0) {
            return new int[0];
        }
        graph = new ArrayList[n];
        for (int node = 0; node < graph.length; node++) {
            graph[node] = new ArrayList<>();
        }
        for (int i = 0; i < richer.length; i++){
            graph[richer[i][1]].add(richer[i][0]);
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++){
            dfs(i, answer, quiet);
        }
        return answer;
    }
    
    
    public int dfs(int node, int[] answer, int[] quiet){
        if (answer[node] == -1) {
            answer[node] = node;
            for (int child: graph[node]) {
                int curr = dfs(child, answer, quiet);
                if (quiet[curr] < quiet[answer[node]])
                    answer[node] = curr;
            }
        }
        return answer[node];
    }
}