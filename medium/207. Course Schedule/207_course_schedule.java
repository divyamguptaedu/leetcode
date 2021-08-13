"""
Performance:
Runtime: 7 ms, faster than 31.70% of Java online submissions for Course Schedule.
Memory Usage: 44.5 MB, less than 12.36% of Java online submissions for Course Schedule.
"""

public class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph to track pointers;
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        // for cycle detection;
        Queue queue = new LinkedList();
        int count = 0;
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
            
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        // increase count till the queue is not empty;
        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }

        // if the courses are exactly what we want;
        if (count == numCourses) {
            return true;
        }
        else {
            return false;
        }    
    }
}