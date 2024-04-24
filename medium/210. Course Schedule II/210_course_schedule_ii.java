//Time: O(v+e)
//Space: O(v+e)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean isPossible = true;
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] numEdgesComingIn = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]); //[1, 0] means, to take course 1, you need to take 0 first. So, we add an edge from 0 to 1.
            numEdgesComingIn[prerequisite[0]]++;
        }


        //prepare topological sort, add the leaf nodes.
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (numEdgesComingIn[i] == 0) {
                queue.add(i);
            }
        }

        //topological sort
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topologicalOrder[nodesVisited] = node;
            nodesVisited++;
            for (Integer neighbor : adj.get(node)) {
                numEdgesComingIn[neighbor]--;
                if (numEdgesComingIn[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (nodesVisited == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}