//I used a depth-first search (DFS) with memoization.
//First, I converted the target coordinates to their absolute values due to symmetry.
//I defined a recursive function that uses a memoization map to store results of
//already computed positions. The base cases handle when the knight reaches the
//target or close to it. Otherwise, the function recursively explores the knight's
//moves, selecting the minimum steps from the possible moves, 
//and stores the result in the memoization map.

//Time: x*y where x and y are the abs values of the target coordinates.
//Space: x*y for memoization map.
class Solution {
    private Map<String, Integer> memoizationMap = new HashMap<>();

    public int minKnightMoves(int x, int y) {
        // Use absolute values because of symmetry
        return findMinMoves(Math.abs(x), Math.abs(y));
    }

    private int findMinMoves(int x, int y) {
        String key = x + "," + y;
        // Check if result is already computed and stored in the map
        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }

        // Base cases
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        } else {
            // Recursively find the minimum steps needed from the knight's possible moves
            int minSteps = Math.min(findMinMoves(Math.abs(x - 1), Math.abs(y - 2)),
                    findMinMoves(Math.abs(x - 2), Math.abs(y - 1))) + 1;
            // Store the result in the map
            memoizationMap.put(key, minSteps);
            return minSteps;
        }
    }
}
