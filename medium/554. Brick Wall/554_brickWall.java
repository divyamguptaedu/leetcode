"""
Performance:
Runtime: 13 ms, faster than 80.21% of Java online submissions for Brick Wall.
Memory Usage: 44.7 MB, less than 93.60% of Java online submissions for Brick Wall.
"""

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int temp = 0;
            List<Integer> current = wall.get(i);
            for (int j = 0; j < current.size() - 1; j++) {
                temp += current.get(j);
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                result = Math.max(result, hashMap.get(temp));
            }
        }
        return (wall.size() - result);
    }
}