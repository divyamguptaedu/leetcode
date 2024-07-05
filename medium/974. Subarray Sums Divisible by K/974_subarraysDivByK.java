//I used a prefix sum approach, tracking remainders of the cumulative sums modulo k. 
//I maintained an array to count occurrences of each remainder. 
//For each element in the array, I updated the prefix sum and used it to find how 
//many previous subarrays could form a new subarray divisible by k. 
//I incremented the count of subarrays using these remainders.
//Time: n where n is the num of elements in the array
//Space: k is the num of possible remainders (mod groups)

/*
Example Walkthrough:
int prefixMod = 0, result = 0;
int[] modGroups = new int[k]; // modGroups = [0, 0, 0, 0, 0]
modGroups[0] = 1; // because a subarray with sum exactly divisible by k will have remainder 0

Iteration through nums:
Element 4:
prefixMod = (0 + 4 % 5 + 5) % 5 = 4 % 5 = 4;
result += modGroups[4]; // result = 0 (no previous subarray with remainder 4)
modGroups[4]++; // modGroups = [1, 0, 0, 0, 1]

Element 5:
prefixMod = (4 + 5 % 5 + 5) % 5 = 9 % 5 = 4;
result += modGroups[4]; // result = 1 (one previous subarray [4] has remainder 4)
modGroups[4]++; // modGroups = [1, 0, 0, 0, 2]

Element 0:
prefixMod = (4 + 0 % 5 + 5) % 5 = 4 % 5 = 4;
result += modGroups[4]; // result = 3 (two previous subarrays [4], [4, 5] have remainder 4)
modGroups[4]++; // modGroups = [1, 0, 0, 0, 3]

Element -2:
prefixMod = (4 + (-2) % 5 + 5) % 5 = (4 - 2 + 5) % 5 = 7 % 5 = 2;
result += modGroups[2]; // result = 3 (no previous subarray with remainder 2)
modGroups[2]++; // modGroups = [1, 0, 1, 0, 3]

Element -3:
prefixMod = (2 + (-3) % 5 + 5) % 5 = (2 - 3 + 5) % 5 = 4 % 5 = 4;
result += modGroups[4]; // result = 6 (three previous subarrays [4], [4, 5], [4, 5, 0] have remainder 4)
modGroups[4]++; // modGroups = [1, 0, 1, 0, 4]

Element 1:
prefixMod = (4 + 1 % 5 + 5) % 5 = 5 % 5 = 0;
result += modGroups[0]; // result = 7 (one previous subarray with remainder 0)
modGroups[0]++; // modGroups = [2, 0, 1, 0, 4]

Result:
After processing all elements, the final count of subarrays whose sums are divisible by k is stored in result:
return result; // result = 7
Thus, the number of subarrays whose sums are divisible by 5 is 7.
*/
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