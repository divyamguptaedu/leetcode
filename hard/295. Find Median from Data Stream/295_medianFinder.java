//To solve this question, we can use two priority queues. One which gives the max element, which we can use for
//left half, and another which gives min element which we can use for right half.
//When it comes to adding a number, if the left pq is empty, we just add there. 
//If the num is > peek of left, then we add to the right pq, otherwise left pq.
//If the size of left is greater by more than 1, then we add the peek of left to right.
//If the size of right is greater, we add the peek of right to left.
//When it comes to finding the median, we just see if the size of two pq is equal, we get peek of both and return the mean.
//Otherwise, we return the peek of left.

//Time: O(logn) for adding. O(1) for finding the median.
//Space: O(n)
class MedianFinder {
    PriorityQueue<Integer> left_max_heap;
    PriorityQueue<Integer> right_min_heap;

    public MedianFinder() {
        this.left_max_heap = new PriorityQueue<>((a, b) -> b - a);
        this.right_min_heap = new PriorityQueue();
    }

    public void addNum(int num) {
        if (left_max_heap.size() == 0) {
            left_max_heap.add(num);
            return;
        }
        if (num > left_max_heap.peek()) {
            right_min_heap.add(num);
        } else {
            left_max_heap.add(num);
        }
        if (left_max_heap.size() - 1 > right_min_heap.size()) {
            right_min_heap.add(left_max_heap.poll());
        } else if (right_min_heap.size() > left_max_heap.size()) {
            left_max_heap.add(right_min_heap.poll());
        }
    }

    public double findMedian() {
        if (left_max_heap.size() == right_min_heap.size()) {
            return ((double) left_max_heap.peek() + right_min_heap.peek()) / 2;
        }
        return (double) left_max_heap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */