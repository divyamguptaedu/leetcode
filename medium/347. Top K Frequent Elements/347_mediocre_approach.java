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



































// median finder
// PriorityQueue<Integer> minQueue;
// PriorityQueue<Integer> maxQueue;
// int size1 = 0;
// int size2 = 0;
// public MedianFinder() {
//     minQueue = new PriorityQueue<>();
//     maxQueue = new PriorityQueue<>(Collections.reverseOrder());
//     size1 = 0;
//     size2 = 0;
// }

// public void addNum(int num) {
//     if(size1 == 0){
//         minQueue.add(num);
//         size1++;
//         return;
//     }
//     if(size1 >= size2){
//         if(num > minQueue.peek()){
//             int poll = minQueue.poll();
//             minQueue.add(num);
//             maxQueue.add(poll);
//             size2++;
//         }else{
//             maxQueue.add(num);
//             size2++;
//         }
//     }else{
//         if(maxQueue.peek() > num){
//             int poll = maxQueue.poll();
//             minQueue.add(poll);
//             maxQueue.add(num);
//         }else{
//             minQueue.add(num);
//         }
//         size1++;
//     }
// }

// public double findMedian() {
//     if(size1 == size2){
//         return (minQueue.peek() * 1.0 + maxQueue.peek() * 1.0)/2;
//     }else{
//         if(size1 > size2){
//             return minQueue.peek();
//         }else{
//             return maxQueue.peek();
//         }
//     }
// }