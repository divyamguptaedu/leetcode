"
Performance:
Runtime: 21 ms, faster than 89.52% of Java online submissions for Random Pick with Weight.
Memory Usage: 43.7 MB, less than 90.10% of Java online submissions for Random Pick with Weight.
"

class Solution {
    Random random;
    int[] nums;
    int total;
    
    public Solution(int[] w) {
       this.random = new Random();
       for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
       }
       this.nums = w;
       this.total = w[w.length - 1];
    }
   
    public int pickIndex() {
       if (this.total == 0) {
           return -1;
       }
       int n = this.random.nextInt(this.total) + 1; 
       int low = 0;
       int high = this.nums.length - 1;
       while (low < high) {
           int mid = low + (high - low) / 2;
           if (this.nums[mid] == n) {
               return mid;
           } else if (this.nums[mid] < n) {
               low = mid + 1;
           } else {
               high = mid;
           }
       }
       return low;
   }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */