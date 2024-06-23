//I implemented a KthLargest class using a PriorityQueue (min-heap). Upon initialization with an array nums, 
//I populated the heap with its elements and maintained its size to k by removing smaller elements if necessary. 
//The add method appends a new element to the heap and adjusts its size to maintain the kth largest element effectively. 
//Each operation ensures the heap remains updated with the k largest elements, 
//allowing quick access to the kth largest element when needed.
//Time: nlogn + mlogk where n is the len of nums, m is the number of calls to add.
//Space: n
class KthLargest {
    private static int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */