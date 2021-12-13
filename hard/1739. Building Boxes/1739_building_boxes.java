"
Performance:
Runtime: 17 ms, faster than 17.14% of Java online submissions for Building Boxes.
Memory Usage: 35.6 MB, less than 85.71% of Java online submissions for Building Boxes.
"

class Solution {
    public int minimumBoxes(int n) {
        int capacity = 1; 
        int maxCapacity = 1;
        int row = 0;
            while (n > 0) {
                row++;
                n = n - capacity;
                if (capacity == maxCapacity) {
                    capacity = 1;
                    maxCapacity++;
                } else
                    capacity++;
            }
        return row;
    }
}