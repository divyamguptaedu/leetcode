"
Runtime: 31 ms, faster than 71.91% of Java online submissions for Next Greater Element II.
Memory Usage: 54.5 MB, less than 66.31% of Java online submissions for Next Greater Element II.
"

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack < Integer> stack = new Stack<>();
        int size = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        stack.push(0);
        for (int i = 1; i < 2*nums.length; i++) {
            int temp = nums[i % size];
            while(!stack.empty() && temp > nums[stack.peek()]) {
                result[stack.peek()] = temp;
                stack.pop();
            }
            if (i < size) {
                stack.push(i);
            }
        }
        return result; 
    }
}