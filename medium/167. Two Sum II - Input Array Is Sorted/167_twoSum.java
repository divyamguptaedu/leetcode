//We can solve this question using a two pointer approach. We can have low pointer at 0 and high pointer at end.
//Now, we can do while low < high, get the sum of the two numbers at pointers
//If sum == target, return
//If sum < target, increment the low pointer
//If sum > target, decrement the high pointer
//If not found, we can return -1, -1.

//Time: O(n)
//Space: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] { low + 1, high + 1 }; //because the array is 1 indexed, not zero.
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] { -1, -1 };
    }
}