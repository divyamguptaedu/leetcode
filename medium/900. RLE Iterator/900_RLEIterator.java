"
Performance:
Runtime: 4 ms, faster than 100.00% of Java online submissions for RLE Iterator.
Memory Usage: 41.9 MB, less than 94.50% of Java online submissions for RLE Iterator.
"

class RLEIterator {
    int[] array;
    int index;
    public RLEIterator(int[] encoding) {
        array = encoding;
        index = 0;
    }
    
    public int next(int n) {
        while (index < array.length && array[index] < n) {
            n -= array[index];
            array[index] = 0;
            index += 2;
        }
        if (index + 1 >= array.length) {
            return -1;
        }
        array[index] -= n;
        return array[index + 1];
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */