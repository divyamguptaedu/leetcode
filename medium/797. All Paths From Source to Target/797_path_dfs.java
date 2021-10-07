"
Performance:
Runtime: 2 ms, faster than 95.02% of Java online submissions for All Paths From Source to Target.
Memory Usage: 40.5 MB, less than 86.85% of Java online submissions for All Paths From Source to Target.
"

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(0);
        helper(0, graph, temp, result);
        return result;
    }
    public void helper(int source,int[][] graph, ArrayList<Integer> temp,List<List<Integer>> result) {
        if (source == graph.length - 1) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < graph[source].length; i++) { 
                temp.add(graph[source][i]);
                helper(graph[source][i], graph, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    
}