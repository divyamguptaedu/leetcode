"
Performance:
Runtime: 7 ms, faster than 84.12% of Java online submissions for Maximum Width Ramp.
Memory Usage: 46.3 MB, less than 70.29% of Java online submissions for Maximum Width Ramp.
"

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        
        int max = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                max = Math.max(max, j - stack.pop());
            }
        }
        return max;
    }
}