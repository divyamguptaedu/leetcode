class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        var previousMax = nums[0];
        var max = Math.max(previousMax, nums[1]);

        for (var houseNum = 2; houseNum < nums.length; houseNum++) {
            var curr = Math.max(max, previousMax + nums[houseNum]);
            previousMax = max;
            max = curr;
        }

        return max;
    }
}