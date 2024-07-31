class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.get(manager[i]).add(i);
            }
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(headID, 0));
        int maxTime = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> employeePair = q.remove();
            int parent = employeePair.getKey();
            int time = employeePair.getValue();
            maxTime = Math.max(maxTime, time);
            for (int adjacent : adjList.get(parent)) {
                q.add(new Pair<>(adjacent, time + informTime[parent]));
            }
        }
        return maxTime;
    }
}