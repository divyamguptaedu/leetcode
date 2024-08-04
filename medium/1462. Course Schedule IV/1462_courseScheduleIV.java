class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] incomingEdges = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, HashSet<Integer>> set = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            set.put(i, new HashSet<>());
        }
        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
            incomingEdges[prereq[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : map.get(node)) {
                set.get(neighbor).add(node);
                set.get(neighbor).addAll(set.get(node));
                incomingEdges[neighbor]--;
                if (incomingEdges[neighbor] == 0) queue.add(neighbor);
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(set.get(query[1]).contains(query[0]));
        }
        return result;
    }
}