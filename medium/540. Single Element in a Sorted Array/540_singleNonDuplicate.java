"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
Memory Usage: 60.7 MB, less than 35.72% of Java online submissions for Single Element in a Sorted Array.
"
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size = nums.length;
        int low = 0;
        int high = size / 2;
        while (low < high) {
            int temp = (low + high) / 2;
            if (nums[2 * temp] != nums[2 * temp + 1]) {
                high = temp;
            } else {
                low = temp + 1;
            }
        }
        return nums[2 * low];
    }
}