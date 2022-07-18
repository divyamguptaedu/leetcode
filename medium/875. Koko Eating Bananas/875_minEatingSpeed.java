"
Performance:
Runtime: 54 ms, faster than 93.14% of Java online submissions for Koko Eating Bananas.
Memory Usage: 54.3 MB, less than 25.16% of Java online submissions for Koko Eating Bananas.

"

class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int right = Integer.MIN_VALUE;
        for (int element : arr) {
            right = Math.max(right, element);
        }
        int left = 1;
        while (left < right) { 
            int middle = (left + right) / 2;
            int current = 0;
            for (int element : arr) {
                current += Math.ceil((element * 1.0) / middle);
            }
            if (current > h) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}