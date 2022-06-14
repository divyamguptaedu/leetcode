"
Performance:
Runtime: 78 ms, faster than 23.53% of Java online submissions for Find K Pairs with Smallest Sums.
Memory Usage: 42.1 MB, less than 46.25% of Java online submissions for Find K Pairs with Smallest Sums.
"

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((x, y) -> x.get(0) + x.get(1) - y.get(0) - y.get(1));
            for (int i : nums1) { 
                for (int j : nums2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    queue.add(temp);
                }
            }
            for (int i = 0 ; i < k && (!queue.isEmpty()); i++) {
                result.add(queue.poll());
            }
        return result;
    }
}