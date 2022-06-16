"
Peformance:
Runtime: 102 ms, faster than 41.20% of Java online submissions for Sort Integers by The Power Value.
Memory Usage: 44 MB, less than 71.33% of Java online submissions for Sort Integers by The Power Value.
"

class Solution {
    public int getKth(int lo, int hi, int k) {
        int [][] result = new int[hi - lo + 1][2];
        for (int i = 0; i < result.length; i++) {
            result[i][1] = power(result[i][0] = i + lo);
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[1]));
        return result[k - 1][0];
    }
    
    int power (int k) {
        int answer = 0;
        while (k != 1) {
            k = (k % 2 == 0) ? k/2 : (3 * k) + 1;
            answer++;
        }
        return answer;
    }
}