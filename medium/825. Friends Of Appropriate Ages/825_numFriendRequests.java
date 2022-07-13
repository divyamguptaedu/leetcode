"
Performance:
Runtime: 4 ms, faster than 85.98% of Java online submissions for Friends Of Appropriate Ages.
Memory Usage: 58 MB, less than 21.04% of Java online submissions for Friends Of Appropriate Ages.
"

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        int result = 0;
        for (int age : ages) {
            count[age]++;
        }
        for (int a = 0; a <= 120; a++) {
            for (int b = (int)(0.5 * a) + 7 + 1; b <= a; b++) {
                result += count[a] * count[b];
                if (a == b) {
                    result -= count[a];
                }
            }
        }
        return result;
    }
}