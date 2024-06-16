//To solve the problem of finding the maximum area of water that can be trapped between two 
//vertical lines in an array, I used the two-pointer technique. Starting with pointers left 
//at the beginning of the array and right at the end, I calculated the area between them and 
//updated maxarea whenever a larger area was found. The width of the container is determined 
//by the difference between right and left, and the height is determined by the shorter of the 
//two vertical lines at height[left] and height[right].

//Time: n
//Space: constant
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}