class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : nums) {
           frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1); 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> frequencyMap.get(a)-frequencyMap.get(b));

        for (int i : frequencyMap.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        for (Integer i : pq) {
            result[index] = i;
            index++;
        }
        return result;
    }
}