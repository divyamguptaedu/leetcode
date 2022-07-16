"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Reordered Power of 2.
Memory Usage: 38.9 MB, less than 98.58% of Java online submissions for Reordered Power of 2.
"

class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] array = helper(N);
        int power = 1;
        for (int i = 0; i <= 31; i++) {
            if (equals(array, helper(power))) {
                return true;
            }
            power <<= 1;
        }
        return false;
    }

    int[] helper(int N) {
        int[] array = new int[10];
        while (N > 0) {
            array[N % 10]++;
            N /= 10;
        }
        return array;
    }

    boolean equals(int[] arrayOne, int[] arrayTwo) {
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i])
                return false;
        }
        return true;
    }
}