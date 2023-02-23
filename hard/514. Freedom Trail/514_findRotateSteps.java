class Solution {
    Map<Character, List<Integer>> charToIndex = new HashMap<>();
    int[][] memory;
    int m;
    int n;
    
    public int findRotateSteps(String ring, String key) {
        this.m = ring.length();
        this.n = key.length();
        memory = new int[m][n];
        for (int i = 0; i < m; i++) {   
            char c = ring.charAt(i);
            charToIndex.putIfAbsent(c, new ArrayList<>());
            charToIndex.get(c).add(i);
        }
        return dp(ring, 0, key, 0);
    }
    
    private int dp(String ring, int i, String key, int j) {
        if (j == n) {
            return 0;
        }
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        int result = Integer.MAX_VALUE;
        for (int k: charToIndex.get(key.charAt(j))) {
            int diff = Math.abs(k - i);
            diff = Math.min(diff, m - diff);
            int subProblem = dp(ring, k, key, j + 1);
            result = Math.min(result, diff + 1 + subProblem);
        }
        
        memory[i][j] = result;
        
        return memory[i][j];
    }
}