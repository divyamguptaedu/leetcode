"
Performance:
Runtime: 374 ms, faster than 87.44% of Java online submissions for Repeated String Match.
Memory Usage: 113.8 MB, less than 70.63% of Java online submissions for Repeated String Match.
"

class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int repeats = b.length() / a.length() + 2;
        int count = 1;
        for (int i = 1; i <= repeats; i++) {
            if (a.contains(b)) {
                return count;
            } else {
                a = a + temp;
                count++;
            }
        }
        return -1;
    }
}