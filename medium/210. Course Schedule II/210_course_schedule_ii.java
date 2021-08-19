"
Performance:
Runtime: 4 ms, faster than 78.02% of Java online submissions for Course Schedule II.
Memory Usage: 40.8 MB, less than 22.27% of Java online submissions for Course Schedule II.
"

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> courses = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int track []= new int[numCourses]; 
        for (int i = 0; i < numCourses; i++){
            if (dfs(courses, i, list, track) == false) {
                return new int[0];
            }
        }
            
        int[] ans = list.stream().mapToInt(i->i).toArray();
        
        return ans;
    }
    
    public boolean dfs(List<List<Integer>> courses, int start, List<Integer> list, int track[]){
        
        if (track[start] == 2) {
        	return true;
        }

        if (track[start] == 1) {
        	return false;
        }
        
        track[start] = 1;
        
        for (int j = 0; j < courses.get(start).size(); j++) {
            if (dfs(courses, courses.get(start).get(j),list, track) == false) {\
            	return false;
            }
        }
        track[start] = 2;
        list.add(start);
        return true;
    }
}