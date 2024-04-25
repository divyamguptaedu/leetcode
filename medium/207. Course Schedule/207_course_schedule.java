//First created an adj list, 
//then did a topological sort BFS while keeping a track of the nodes in the sort, 
//and checked in the end if that count == numCourses.
//Time: O(v+e)
//Space: O(v+e)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] numEdgesComingIn = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]); //[1, 0] means, to take course 1, you need to take 0 first. So, we add an edge from 0 to 1.
            numEdgesComingIn[prerequisite[0]]++;
        }

        //prepare topological sort, add the leaf nodes.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numEdgesComingIn[i] == 0) {
                queue.offer(i);
            }
        }

        //topological sort
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;
            for (int neighbor : adj.get(node)) {
                numEdgesComingIn[neighbor]--;
                if (numEdgesComingIn[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}