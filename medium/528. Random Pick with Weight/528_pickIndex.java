//To solve this question, we need a way to account for the probability.
//To do that, we can in the constructor, initialize a commulative sum or prefix sum array.
//Once we have the commulative sum array and the total sum, in the pickIndex method, we can find a target using binary search.
//For that, we can get a target by multiplying total sum by math.random which gives values between 0 and 1. 
//And then we can do binary search for that target in the cummulative sum array.
//In the end, we can return the low index, but that's what we need to return, the index, not the value.

//Time: Constructor takes O(n), pickIndex takes O(logn)
//Space: Constructor takes O(n), pickIndex takes O(1)
class Solution {
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random(); //Math.random returns values between 0 and 1.

        // run a binary search to find the target zone
        int low = 0;
        int high = this.prefixSums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}