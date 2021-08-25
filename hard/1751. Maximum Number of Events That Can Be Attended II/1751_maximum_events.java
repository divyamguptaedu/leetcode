"
Performance:
Runtime: 31 ms, faster than 88.62% of Java online submissions for Maximum Number of Events That Can Be Attended II.
Memory Usage: 81.8 MB, less than 67.07% of Java online submissions for Maximum Number of Events That Can Be Attended II.
"

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int [][] store = new int [n][k + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, events[i][2]);
            store[i][1] = events[i][2];
        }
        if (k == 1)
            return max;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (events[j][1] < events[i][0]) {
                    for (int x = 2; x <= k; x++) {
                        store[i][x] = Math.max(store[i][x], store[j][x - 1] + events[i][2]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                max = Math.max(store[i][j], max);
            }
        }
        return max;
    }
}