"
Performance:
Runtime: 19 ms, faster than 71.43% of Java online submissions for Number of Valid Subarrays.
Memory Usage: 47.4 MB, less than 52.38% of Java online submissions for Number of Valid Subarrays.
"

class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int count = 0;
        for (int i = 1;i < nums.length; i++) {
            while(stack.size() > 0 &&nums[i] < nums[stack.peek()]) {
                int peek = stack.pop();
                count += i - peek;
            }
            stack.push(i);
        }
        while (stack.size() != 0) {
            int peek = stack.pop();
            count += nums.length - peek;
        }
        return count;
    }
}