"
Performance: Time Limit Exceeded
"
class Solution {
    private ArrayList<Integer> nums;
    private Random random;

    public Solution(int[] w) {
        this.nums = new ArrayList<>();
        this.random = new Random();
        
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                this.nums.add(i);
            }
        }
    }
    
    public int pickIndex() {
        int n = this.random.nextInt(nums.size());
        return nums.get(n);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */