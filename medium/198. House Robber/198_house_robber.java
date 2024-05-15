//I considered the first house and set it as the previous maximum. 
//Then, I calculated the maximum between the first two houses. Iterating through the remaining houses, 
//I determined the maximum amount I could rob without alerting the police by considering the current house's loot and 
//the loot from the house before the previous one. Finally, I returned the maximum amount achievable. 
//The logic involved dynamically updating the maximum loot considering the constraints of adjacent houses.

//Time: O(n)
//Space: O(1)
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