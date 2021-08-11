class MedianFinder {

	PriorityQueue<Integer> minHeap;
	int size;

    /** initialize your data structure here. */
    public MedianFinder() {
    	this.minHeap = new PriorityQueue<>();
    	this.size = 0;
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        size++;
    }
    
    public double findMedian() {
    	double median = 0.0;
    	ArrayList<Integer> temp = new ArrayList<>();
        if (size % 2 == 0) {
        	for (int i = 0; i < (size / 2) - 1; i++) {
        		temp.add(minHeap.poll());
        	}
        	int i = minHeap.poll();
        	int j = minHeap.poll();
        	temp.add(i);
        	temp.add(j);
        	median = (i + j) / 2.0;
        	for (int x : temp) {
        		minHeap.add(x);
        	}
        	temp = new ArrayList<>();
        }
        if (size % 2 == 1) {

        	for (int i = 0; i < size / 2; i++) {
        		temp.add(minHeap.poll());
        	}
        	int k = minHeap.poll();
        	median = k;
        	temp.add(k);
        	for (int x : temp) {
        		minHeap.add(x);
        	}
        	temp = new ArrayList<>();
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */