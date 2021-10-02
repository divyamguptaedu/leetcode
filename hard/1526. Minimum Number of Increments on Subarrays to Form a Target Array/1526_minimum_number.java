"
Performance:
Runtime: 4 ms, faster than 40.48% of Java online submissions for Minimum Number of Increments on Subarrays to Form a Target Array.
Memory Usage: 95.2 MB, less than 30.79% of Java online submissions for Minimum Number of Increments on Subarrays to Form a Target Array.
"

class Solution {
   public int minNumberOperations(int[] target) {
        int count = target[0];
        for (int i = 1 ; i < target.length; i++) {
            if (target[i] > target[i-1])
                count += (target[i] - target[i-1]);
        }
        return count;
    }
}