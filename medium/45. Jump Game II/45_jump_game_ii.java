//I approached this problem by simulating jumps, aiming to minimize the number of jumps 
//needed to reach the last index. Initially positioned at the first index, I iterated 
//through the array, updating the farthest reachable index for each jump. When reaching 
//the end of the current jump range, I incremented the jump count and updated the end of 
//the next jump range to the farthest reachable index encountered so far. 
//By efficiently adjusting the jump ranges, I ensured that each jump covers as much 
//distance as possible, minimizing the total number of jumps needed to reach the last index.

//Time: O(n)
//Space: O(1)
class Solution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0;
        int n = nums.length;
        int curEnd = 0;
        int curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
}