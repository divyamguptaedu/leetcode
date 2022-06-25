"
Performance:
Runtime: 19 ms, faster than 30.77% of Java online submissions for K-diff Pairs in an Array.
Memory Usage: 48.1 MB, less than 47.12% of Java online submissions for K-diff Pairs in an Array.
"

class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry:hashMap.entrySet()) {
            if ((hashMap.containsKey(entry.getKey()+k) && k != 0) || (k == 0 && entry.getValue() > 1)) {
                count++;
            }
        }
        return count;
    }
}