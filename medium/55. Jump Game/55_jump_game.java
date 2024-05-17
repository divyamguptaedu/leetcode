//I tackled this problem by simulating jumps from the last index towards the first. 
//Starting from the last position, I checked if the current index, combined with its jump length
//could reach the last reachable position. If it could, I updated the last reachable 
//position to the current index. By iteratively updating the last reachable position, 
//I ensured that it always represents the furthest position that can be reached from 
//the current index. Finally, if the last reachable position reaches the b
//eginning (index 0), it signifies that the last index is reachable, returning true; 
//otherwise, it returns false.

//Time: O(n)
//Space: O(1)
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}