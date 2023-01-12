class Solution {
    List<Integer>[] possible;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        possible = new ArrayList[n];
        for (int i=0; i<n; i++)
            possible[i] = new ArrayList<>();
        for (int[] edge : edges) {
            possible[edge[0]].add(edge[1]);
            possible[edge[1]].add(edge[0]); 
        }
        boolean[] visited = new boolean[n];
        int[] answer = new int[n];
        helperFunction(0,labels.toCharArray(),answer,visited);
        return answer;
    }
    Map<Character,Integer> helperFunction(int node, char[] labels, int[] answer, boolean[] visited) {
        Map<Character,Integer> current = new HashMap<>();
        visited[node] = true; 
        for (int i : possible[node]) {
            if (visited[i]) continue;
            Map<Character,Integer> map = helperFunction(i, labels, answer, visited);
            for (var entry : map.entrySet()) 
            {
                current.put(entry.getKey(), current.getOrDefault(entry.getKey(),0)+ + entry.getValue());
            }
        }
        current.put(labels[node], current.getOrDefault(labels[node],0)+1);
        answer[node] = current.get(labels[node]);
        return current;
    }
}