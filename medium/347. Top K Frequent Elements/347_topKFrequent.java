//To solve this question we can use a hashmap to calculate the frequency, and a pq to get the k most frequent
//elements. So, we make the frequency map, use a pq which sorts based on the count in the frequency map. 
//We just add all the elements to the pq, pop when length > k, and then in the end add the remaining elements in pq
//to the output array.

//Time: O(NlogK)
//Space: O(N + k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // 3. Build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}