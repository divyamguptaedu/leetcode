"
Performance:
Runtime: 14 ms, faster than 70.16% of Java online submissions for Shortest Path in Binary Matrix.
Memory Usage: 40.5 MB, less than 32.13% of Java online submissions for Shortest Path in Binary Matrix.
"

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid == null || grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        
        int m = grid.length; //square matrix m == n
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        if (m == 1) {
            return 1;
        }
        
        queue.add(new Pair(0,0));
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            Pair<Integer,Integer> pos = queue.poll();
            for(int[] dir : directions){
                int newPosX = pos.getKey() + dir[0];
                int newPosY = pos.getValue() + dir[1];
                if(newPosX >= m || newPosX < 0 || newPosY >= m || newPosY < 0 || grid[newPosX][newPosY] >= 1)
                    continue;
                if(newPosX == m - 1 && newPosX == newPosY)
                    return grid[pos.getKey()][pos.getValue()] + 1;
                grid[newPosX][newPosY] =  grid[pos.getKey()][pos.getValue()] + 1; 
                queue.offer(new Pair(newPosX,newPosY));
            }
        }
        return -1;
    }
}