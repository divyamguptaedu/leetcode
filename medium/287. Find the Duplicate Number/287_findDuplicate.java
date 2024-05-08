//To solve this question in constant space, we can use Floyd's Tortoise and Hare theorem. 
//In this theorem, we will have two pointers tortoise and hare, hare is twice as fast as the tortoise. 
//Both will start moving in the nums array, which means that they will treat the values at every index as their next destination and will directly go there.
//At some point, they will meet at an intersection point. After they meet, we will make them move at the same one step speed,
//and the next they meet, that index will be the start of the cycle point, whose value is our answer.

//Time: O(n)
//Space: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        tortoise = nums[tortoise];
        hare = nums[nums[hare]];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}