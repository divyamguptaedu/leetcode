"
Performance:
Runtime: 21 ms, faster than 84.77% of Java online submissions for Flip String to Monotone Increasing.
Memory Usage: 54 MB, less than 95.92% of Java online submissions for Flip String to Monotone Increasing.
"

class Solution {
    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        int[] array = new int[size];
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '1') {
                total++; 
            }
            array[i] = total;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= size; i++) { 
            int before = i == 0? 0 : array[i - 1];
            int after = (size - i) - (total - before);   
            int current = before + after;
            result = Math.min(result, current);
        }
        return result;
    }
}