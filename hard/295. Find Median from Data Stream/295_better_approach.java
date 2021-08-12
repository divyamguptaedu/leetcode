"""
Performance:
Runtime: 84 ms, faster than 51.82% of Java online submissions for Find Median from Data Stream.
Memory Usage: 66.5 MB, less than 48.58% of Java online submissions for Find Median from Data Stream.
"""

class MedianFinder {

    // form a minHeap and a maxHeap;
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    int sizeA = 0;
    int sizeB = 0;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    // add half elements to min and half to max.
    public void addNum(int num) {
        if (sizeA == 0){
            minQueue.add(num);
            sizeA++;
            return;
        }
        if (sizeA >= sizeB){
            if (num > minQueue.peek()){
                int poll = minQueue.poll();
                minQueue.add(num);
                maxQueue.add(poll);
                sizeB++;
            } else {
                maxQueue.add(num);
                sizeB++;
            }
        }else {
            if(maxQueue.peek() > num) {
                int poll = maxQueue.poll();
                minQueue.add(poll);
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
            sizeA++;
        }
    }

    // compute median easily by just peeking;
    public double findMedian() {
        if(sizeA == sizeB){
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        } else {
            if (sizeA > sizeB){
                return minQueue.peek();
            } else {
                return maxQueue.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */