"""
Performance:
Runtime: 38 ms, faster than 12.71% of Java online submissions for Maximal Network Rank.
Memory Usage: 40 MB, less than 29.07% of Java online submissions for Maximal Network Rank.
"""

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

    	// hashset for unique values;
        int[] degree = new int[n];
        HashSet<String> valueSet = new HashSet<>();
        
        for(int[] x : roads) {
            degree[x[0]]++;
            degree[x[1]]++;
            valueSet.add(x[0]+"-"+x[1]);
            valueSet.add(x[1]+"-"+x[0]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1;j < n; j++) {
                int val = degree[i] + degree[j];
                if (valueSet.contains((i + "-" + j))) {
                    val -= 1;
                }
                // choose maximum;
                res = Math.max(res, val);
            }
        }
        return res;
    }
}