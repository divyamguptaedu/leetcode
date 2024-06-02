//I iterated through the sorted array of integers, 
//checking for missing numbers within the inclusive range [lower, upper]. 
//Whenever I encountered a missing number, I constructed a range from the previous number 
//(inclusive) to the current number (exclusive), thereby covering the missing range. 
//I handled edge cases separately: adding the full range if the array is empty and adding the 
//range from the last number to the upper bound if needed. 
//This approach ensures coverage of all missing numbers with the shortest possible ranges.

//Time: O(n)
//Space: O(1)
class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        
        // Initialize the result list to store missing ranges
        List<List<Integer>> result = new ArrayList<>();

        // If the input array is empty, add the full range [lower, upper]
        if (nums.length == 0) {
            result.add(List.of(lower, upper));
        }

        // Initialize a variable to keep track of the previous number
        int prev = lower;

        // Iterate through the sorted array of integers
        for (int n : nums) {
            // If the current number matches the previous number, increment prev
            if (n == prev) {
                prev++;
            } 
            // If there is a missing number between prev and n, add the range to the result
            else {
                List<Integer> range = new ArrayList<>();
                range.add(prev);
                range.add(n - 1);
                result.add(range);
                prev = n + 1; // Update prev to the next number after n
            }
        }

        // If the last number in the array is not equal to upper, add the range from the last number to upper
        if (nums.length > 0 && nums[nums.length - 1] != upper) {
            List<Integer> range = new ArrayList<>();
            range.add(nums[nums.length - 1] + 1);
            range.add(upper);
            result.add(range);
        }

        // Return the list of missing ranges
        return result;
    }
}