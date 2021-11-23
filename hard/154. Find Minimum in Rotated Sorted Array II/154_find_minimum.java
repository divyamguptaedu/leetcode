"
Performance:
Runtime: 1 ms, faster than 44.25% of Java online submissions for Find Minimum in Rotated Sorted Array II.
Memory Usage: 40.7 MB, less than 31.65% of Java online submissions for Find Minimum in Rotated Sorted Array II.
"
class Solution {
    
    static int[] array;
    
    public static int binarySearch(int start, int end) {
        
        if (array[start] < array[end] && start == 0) {
            return array[start];
        }
        
        if (array[start] < array[end] && array[start - 1] > array[start]) {
            return array[start];
        }
        
        if (start == end) {
            return array[start];
        }
        
        int middle = start + (end - start) / 2;
        
		if (array[start] > array[middle]) {
            return binarySearch(start, middle);
        } else if (array[middle] > array[end]) {
			return binarySearch(middle + 1, end);
        } else {
			int leftMin = binarySearch(start, middle);
			int rightMin = binarySearch(middle + 1, end);
			return Math.min(leftMin, rightMin);
		}
    }
    
    public int findMin(int[] array) {
        this.array = array;
        int answer = binarySearch(0, array.length - 1);
        
        return answer;
    }
}