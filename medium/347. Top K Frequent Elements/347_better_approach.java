"""
Performance:
Runtime: 12 ms, faster than 27.63% of Java online submissions for Top K Frequent Elements.
Memory Usage: 41.6 MB, less than 54.75% of Java online submissions for Top K Frequent Elements.
"""

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int x : nums) {
            if (valueMap.get(x) == null) {
                valueMap.put(x, 1);
            } else {
                valueMap.put(x, valueMap.get(x) + 1);
            }
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> valueMap.get(a) - valueMap.get(b));
        for (int y : valueMap.keySet()) {
            maxHeap.add(y);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}