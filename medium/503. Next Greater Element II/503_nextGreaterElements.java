//I used a stack to solve the problem of finding the next greater element in a circular array. 
//I iterated over the array twice to simulate the circular behavior. 
//Starting from the end of the array, I compared each element with the top of the stack. 
//If the stack's top was less than or equal to the current element, 
//I popped elements until finding a greater one or the stack became empty. 
//I then assigned the next greater element to the current position. 
//If no greater element was found, I assigned -1.

//Time: O(n)
//Space: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length]; // Result array to store next greater elements
        Stack<Integer> stack = new Stack<Integer>(); // Stack to store elements
        int len = nums.length; // Length of the input array

        // Iterate over the array twice for circular behavior
        for (int i = (2 * len) - 1; i >= 0; i--) {
            // Ensure the top of the stack is greater than the current element
            while (stack.size() != 0 && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            // Assign the next greater element if within the first iteration
            if (i < len) {
                if (stack.size() != 0) {
                    ans[i % len] = stack.peek();
                } else {
                    ans[i % len] = -1;
                }
            }
            // Push the current element to the stack
            stack.push(nums[i % len]);
        }
        return ans;
    }
}