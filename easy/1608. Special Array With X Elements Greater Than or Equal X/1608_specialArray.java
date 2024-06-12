//I counted the frequency of each number up to the length of the array using a
//frequency array. For numbers greater than the array length, 
//I incremented the last element of the frequency array. 
//Then, I iterated from the highest possible value down to 1, k
//eeping a cumulative count of numbers greater than or equal to the current value. 
//If this cumulative count equaled the current value, I returned it. 
//If no such value existed, I returned -1.

//Time: n
//Space: n
class Solution {
    public int specialArray(int[] nums) {
        int arrayLength = nums.length;
        int[] frequency = new int[arrayLength + 1];

        // Count the frequency of each number, capping at arrayLength
        for (int num : nums) {
            frequency[Math.min(arrayLength, num)]++;
        }

        int countGreaterOrEqual = 0;
        // Traverse from arrayLength to 1 to find the special value
        for (int i = arrayLength; i >= 1; i--) {
            countGreaterOrEqual += frequency[i];
            if (countGreaterOrEqual == i) {
                return i;
            }
        }

        // If no special value is found, return -1
        return -1;
    }
}