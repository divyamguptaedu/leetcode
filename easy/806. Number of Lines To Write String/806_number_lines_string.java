"
Performance:
Runtime: 1 ms, faster than 58.88% of Java online submissions for Number of Lines To Write String.
Memory Usage: 42 MB, less than 56.07% of Java online submissions for Number of Lines To Write String.
"

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int temp = 0;
        int[] result = {1, 0};
        for (int i = 0; i < s.length(); i++) {
            if (temp + widths[s.charAt(i) - 97] <= 100) {
                temp += widths[s.charAt(i) - 97];
            } else {
                i--;
                temp = 0;
                result[0]++;
            }
        }
        result[1] = temp;
        return result;
        
    }
}