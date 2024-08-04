//First created an adj list, 
//then did a topological sort BFS while keeping a track of the nodes in the sort, 
//and checked in the end if that count == numCourses, 
//then returned the topological sort if earlier condition true.
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


//another solution
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int index = 0;
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] incomingEdges = new int[numCourses];
        for (int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());
        for (int[] prereq : prerequisites) {
            map.get(prereq[1]).add(prereq[0]);
            incomingEdges[prereq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (incomingEdges[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index] = node;
            index++;
            for (int neighbor : map.get(node)) {
                incomingEdges[neighbor]--;
                if (incomingEdges[neighbor] == 0) queue.add(neighbor);
            }
        }
        if (index == numCourses) return result;
        return new int[0];
    }
}