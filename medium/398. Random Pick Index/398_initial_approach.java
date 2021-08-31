"
Performance:
Runtime: 134 ms, faster than 6.16% of Java online submissions for Random Pick Index.
Memory Usage: 73.1 MB, less than 10.19% of Java online submissions for Random Pick Index.
"

class Solution {
    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < this.nums.length; ++i) {
            if (this.nums[i] == target) {
                indexList.add(i);
            }
        }
        int length = indexList.size();
        int randomIndex = indexList.get(random.nextInt(length));
        return randomIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */