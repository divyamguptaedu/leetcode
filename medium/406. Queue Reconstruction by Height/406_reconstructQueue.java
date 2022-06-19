"""
Performance:
Runtime: 7 ms, faster than 93.58% of Java online submissions for Queue Reconstruction by Height.
Memory Usage: 42.9 MB, less than 96.90% of Java online submissions for Queue Reconstruction by Height.
"""

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return y[0] - x[0];
        });
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] unit : people) {
            result.add(unit[1], unit);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}