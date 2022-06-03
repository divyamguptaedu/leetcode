/*
Runtime: 17 ms, faster than 53.18% of Java online submissions for Total Appeal of A String.
Memory Usage: 48.5 MB, less than 76.64% of Java online submissions for Total Appeal of A String.
*/

class Solution {
    public long appealSum(String s) {
        long result = 0;
        long current = 0;
        long previous[] = new long[26];
        for (int i = 0; i < s.length(); i++) {
            current += i + 1 - previous[s.charAt(i) - 'a'];
            previous[s.charAt(i) - 'a'] = i + 1;
            result += current;
        }    
    return result;
    }
}