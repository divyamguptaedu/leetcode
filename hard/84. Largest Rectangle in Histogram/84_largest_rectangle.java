//I tackled the problem of finding the largest rectangle in a histogram by using a stack-based 
//approach to efficiently calculate the maximum area. Starting with a stack initialized with -1 
//to mark the base, I iterated through each bar of the histogram. For each bar, I
// checked if it could potentially extend the largest rectangle found so far. 
//y maintaining bars in a non-decreasing order in the stack, I could quickly calculate areas 
//by popping from the stack when encountering a shorter bar, calculating the area with the popped 
//bar as the smallest height.

/* Example
First Loop (Traversing the histogram bars):
i = 0 (heights[0] = 2):

Stack: [-1] -> [-1, 0]
maxArea = 0
i = 1 (heights[1] = 1):

Stack: [-1, 0]
Pop 0
Calculate area: 2 * 1 = 2
maxArea = 2
Stack: [-1] -> [-1, 1]
maxArea = 2
i = 2 (heights[2] = 5):

Stack: [-1, 1] -> [-1, 1, 2]
maxArea = 2
i = 3 (heights[3] = 6):

Stack: [-1, 1, 2] -> [-1, 1, 2, 3]
maxArea = 2
i = 4 (heights[4] = 2):

Stack: [-1, 1, 2, 3]
Pop 3
Calculate area: 6 * 1 = 6
maxArea = 6
Stack: [-1, 1, 2]
Pop 2
Calculate area: 5 * 2 = 10
maxArea = 10
Stack: [-1, 1] -> [-1, 1, 4]
maxArea = 10
i = 5 (heights[5] = 3):

Stack: [-1, 1, 4] -> [-1, 1, 4, 5]
maxArea = 10
Second Loop (Processing remaining bars in the stack):
Stack: [-1, 1, 4, 5]

Pop 5
Calculate area: 3 * 1 = 3
maxArea = 10
Stack: [-1, 1, 4]
Stack: [-1, 1, 4]

Pop 4
Calculate area: 2 * 4 = 8
maxArea = 10
Stack: [-1, 1]
Stack: [-1, 1]

Pop 1
Calculate area: 1 * 6 = 6
maxArea = 10
Stack: [-1]
Final State:
stack = [-1]
maxArea = 10
Thus, the maxArea is 10 at the end of processing.

*/
/**
 * Time Complexity: O(n) - Each bar is pushed and popped from the stack at most once.
 * Space Complexity: O(n) - Extra space used for the stack.
 */
 
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // Use a stack to keep track of indices of histogram bars
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // Push -1 as the base index to calculate width easily
        int length = heights.length;
        int maxArea = 0;
        
        // Traverse through each bar in the histogram
        for (int i = 0; i < length; i++) {
            // Maintain non-decreasing order of heights in the stack
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // Pop from stack and calculate the area for the popped bar
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1; // Width is calculated as (right index - left index - 1)
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            // Push current index onto the stack
            stack.push(i);
        }
        
        // Process remaining bars in the stack
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1; // Width for the last bar is from index to end of array
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        
        return maxArea;
    }
}