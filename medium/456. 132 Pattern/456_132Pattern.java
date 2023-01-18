class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int maximum = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maximum) {
                return true;
            }
            while (!st.isEmpty() && nums[i] > st.peek()) {
                maximum = Math.max(maximum, st.pop());
            }
            st.push(nums[i]);
        }
        return false;
    }
}