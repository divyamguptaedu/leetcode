//I used a monotonic stack to solve this problem. 
//I iterated through the heights array from left to right, 
//keeping track of the indices of the people in the stack. 
//For each person, I compared their height with the height of the person on top of the stack. 
//If the current person was taller, I increased the count of visible people for the person on
//the stack and popped the stack. If there was still someone in the stack, I increased their 
//count as well. Finally, I pushed the current person's index onto the stack.

//Time: n
//Space: n

class Solution {
    public int[] canSeePersonsCount(final int[] heights) {
        int[] result = new int[heights.length];
        int[] stack = new int[heights.length];
        int idx = -1;

        // Iterate from left to right
        for (int i = 0; i < heights.length; ++i) {
            // Pop the stack while the current person is taller than the person on top of the stack
            while (idx > -1 && heights[stack[idx]] <= heights[i])
                result[stack[idx--]]++;
            // If there's still someone in the stack, the current person can see them too
            if (idx > -1)
                result[stack[idx]]++;
            // Push the current person's index onto the stack
            stack[++idx] = i;
        }

        return result;
    }
}
