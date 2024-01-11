class MovingAverage {
    List<Integer> list;
    double total;
    int size;
    public MovingAverage(int size) {
        list = new ArrayList<>();
        total = 0;
        this.size = size;
    }
    
    public double next(int val) {
        list.add(val);
        total += val;
        if (list.size() > size) {
            total -= list.removeFirst();
            return total/size;
        } else {
            return total/list.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */