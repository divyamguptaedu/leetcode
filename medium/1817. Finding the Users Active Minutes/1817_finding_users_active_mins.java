"
Performance:
Runtime: 132 ms, faster than 6.49% of Java online submissions for Finding the Users Active Minutes.
Memory Usage: 169.6 MB, less than 5.82% of Java online submissions for Finding the Users Active Minutes.
"

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] log: logs) {
            map.put(log[0], new HashSet<Integer>());
        }
        for (int[] log: logs) {
            map.get(log[0]).add(log[1]);
        }
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            frequencyMap.put(i,0);
        }
        for (Map.Entry<Integer, HashSet<Integer>> valueMap: map.entrySet()) {
            if (frequencyMap.containsKey(valueMap.getValue().size())) {
                frequencyMap.put(valueMap.getValue().size(), frequencyMap.get(valueMap.getValue().size()) + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> valueMap: frequencyMap.entrySet()) {
            result[valueMap.getKey() - 1] = valueMap.getValue();
        }
        
        return result;
    }
}