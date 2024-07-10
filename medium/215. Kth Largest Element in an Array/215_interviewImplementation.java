import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the min-heap
        for (int num : nums) {
            minHeap.add(num);
            // If heap size exceeds k, remove the smallest element (maintaining k largest
            // elements)
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap now contains the kth largest element
        return minHeap.peek();
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();

        // Example usage
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element in the array is: " + result);
    }
}