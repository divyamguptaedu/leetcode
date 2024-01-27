class Solution {
    public int countHillValley(int[] nums) {
        int counter = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                int index1 = i - 1;
                while (index1 > 0 && nums[index1] == nums[i]) {
                    index1--;
                }
                int index2 = i + 1;
                while (index2 < nums.length && nums[index2] == nums[i]) {
                    index2++;
                }
                if (nums[index1] > nums[i] && nums[index2] > nums[i]) {
                    counter++;
                }
                if (nums[index1] < nums[i] && nums[index2] < nums[i]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}