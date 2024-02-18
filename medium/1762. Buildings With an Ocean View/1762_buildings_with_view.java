"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Buildings With an Ocean View.
Memory Usage: 55.2 MB, less than 45.83% of Java online submissions for Buildings With an Ocean View.
"
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> buildings = new ArrayList<>();
        int highest = heights.length - 1;
        buildings.add(highest);
        for (int i = highest - 1; i >= 0; i--) {
            if (heights[i] <= heights[highest]) {
                continue;
            }
            buildings.add(i);
            highest = i;
        }

        int size = buildings.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = buildings.get(size - i - 1);
        }

        return result;
    }
}