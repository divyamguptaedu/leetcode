//I approached the problem of finding the number of distinct islands in a binary matrix by identifying each island's shape through DFS traversal. 
//For each island found (a connected component of '1's), I captured its shape by recording the relative positions of its cells in relation to its top-left corner. 
//These relative positions were then used to compute all possible pairwise distances between cells within the island. 
//By storing these distances in a map, I ensured that the shape of each island could be uniquely represented regardless of its orientation or reflection. 
//+Finally, using a set to store these maps ensured that only unique island shapes were counted.
//Time: mnk^2 where m and n are dimensions and k is the max number of cells in an island
//Space: mn
class Solution {
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numDistinctIslands2(int[][] grid) {
        Set<Map<Integer, Integer>> distinctIslands = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    List<int[]> positions = new ArrayList<>();
                    getIsland(grid, r, c, positions);
                    Map<Integer, Integer> distanceMap = computeDistanceMap(positions);
                    distinctIslands.add(distanceMap);
                }
            }
        }
        
        return distinctIslands.size();
    }
    
    private void getIsland(int[][] grid, int r, int c, List<int[]> positions) {
        positions.add(new int[]{r, c});
        grid[r][c] = 0; // Mark as visited
        
        for (int[] dir : directions) {
            int rNext = r + dir[0];
            int cNext = c + dir[1];
            if (rNext >= 0 && rNext < grid.length && cNext >= 0 && cNext < grid[0].length && grid[rNext][cNext] == 1) {
                getIsland(grid, rNext, cNext, positions);
            }
        }
    }
    
    private Map<Integer, Integer> computeDistanceMap(List<int[]> positions) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int n = positions.size();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = computeDistance(positions.get(i), positions.get(j));
                distanceMap.put(dist, distanceMap.getOrDefault(dist, 0) + 1);
            }
        }
        
        return distanceMap;
    }
    
    private int computeDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}