class MedianFinder {

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    int sizeA = 0;
    int sizeB = 0;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

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