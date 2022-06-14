"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Water and Jug Problem.
Memory Usage: 41.6 MB, less than 54.97% of Java online submissions for Water and Jug Problem.
"

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false; 
        }
        int temp = jug1Capacity;
        int result = jug2Capacity % jug1Capacity;
        while (result != 0) {
            int tempTwo = temp;
            temp = result;
            result = tempTwo % result;
        }
        if (targetCapacity % temp == 0) {
            return true;
        }
        return false;
    }
}