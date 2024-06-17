//First, we will iterate and find the max element.
//Using two pointers (start and end), I traversed the array to count occurrences of max. 
//For each end, if nums[end] equaled max, I incremented count. 
//When count reached k, I calculated the number of valid subarrays (start to end) and added it to result. 
//Then we will move the start as needed to maintain the count condition, 
//I accumulated the total count of subarrays meeting the criteria. 

//Time: n
//Space: constant
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;

        for (int x : nums) {
            max = Math.max(x, max);
        }

        long count = 0;
        long result = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                count++;
            }
            while (count == k) {
                result += 1 + (nums.length - 1 - end);
                if (nums[start] == max) {
                    count--;
                }
                start++;
            }
        }
        return result;
    }
}