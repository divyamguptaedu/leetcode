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
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int y : valueMap.keySet()) {
            keyMap.put(valueMap.get(y), y);
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int z : keyMap.keySet()) {
            array.add(z);
        }
        MaxHeap heap = new MaxHeap(array);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (keyMap.get(heap.remove()));
        }
        return result;
    }
}
