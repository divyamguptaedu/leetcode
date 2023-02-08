class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int maxJump = 0;
        int positionAfterMaxJump = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (positionAfterMaxJump == i) {
                jumps++;
                positionAfterMaxJump = maxJump;
            }
            if (positionAfterMaxJump >= n -1) {
                return jumps;
            }
        }
        return jumps;
    }
}