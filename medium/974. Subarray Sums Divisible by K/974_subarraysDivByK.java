//I used a prefix sum approach, tracking remainders of the cumulative sums modulo k. 
//I maintained an array to count occurrences of each remainder. 
//For each element in the array, I updated the prefix sum and used it to find how 
//many previous subarrays could form a new subarray divisible by k. 
//I incremented the count of subarrays using these remainders.
//Time: n where n is the num of elements in the array
//Space: k is the num of possible remainders (mod groups)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num : nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }
}