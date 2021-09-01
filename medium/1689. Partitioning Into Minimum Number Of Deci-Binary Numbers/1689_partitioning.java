"
Performance:
Runtime: 7 ms, faster than 45.27% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
Memory Usage: 52.1 MB, less than 6.92% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
"

class Solution {
    public int minPartitions(String n) {
        int size = n.length();
        char max = '0';
        for (int i = 0; i < size; i++) {
            if (n.charAt(i) > max) {
                max = n.charAt(i);
            }
        }

        return Integer.parseInt(String.valueOf(max));
    }
}