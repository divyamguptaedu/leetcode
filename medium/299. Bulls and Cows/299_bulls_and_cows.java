"""
Performance:
Runtime: 0 ms, faster than 98.34% of Java online submissions for Bulls and Cows.
Memory Usage: 40.6 MB, less than 23.54% of Java online submissions for Bulls and Cows.
"""

class Solution {
    public String getHint(String secret, String guess) {
        int temp[] = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            int x = secret.charAt(i) - '0';
            int y = guess.charAt(i) - '0';
            if (x == y) {
                bull++;
            } else {
                if (temp[x] < 0) {
                    cow++;
                }
                if (temp[y] > 0) {
                    cow++;
                }
                temp[x]++;
                temp[y]--;
            }
        }
        return bull + cow + "A" + "B";
    }
}