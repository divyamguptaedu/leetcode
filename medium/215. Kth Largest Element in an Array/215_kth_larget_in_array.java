//To solve this question, we can just add all the elements to a pq, and make sure that we are removing from the heap
//as soon as the heap size is > k, so that we are only keeping the top k elements in the heap. 
//Once the loop ends, we just return the heap.peek element, which is the kth largest element in the array.

//Time: O(nlogk)
//Space: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
        return heap.peek();
    }
}