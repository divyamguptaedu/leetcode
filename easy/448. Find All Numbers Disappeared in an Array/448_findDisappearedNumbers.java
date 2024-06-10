//I iterate through the input array, treating each value as a new index.
//For each value, I mark its corresponding index as visited by making its value negative.
//This way, I can track which numbers have appeared.
//After the iteration, I traverse the array again to find the positive values,
//indicating the missing numbers. These missing numbers are added to the result list.

//Time: n
//Space: 1
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {
            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;
            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();
        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}