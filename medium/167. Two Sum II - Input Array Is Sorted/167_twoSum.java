"
Performance:
Runtime: 2 ms, faster than 71.55% of Java online submissions for Two Sum II - Input Array Is Sorted.
Memory Usage: 50.3 MB, less than 22.48% of Java online submissions for Two Sum II - Input Array Is Sorted.
"

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length-1;
        while (numbers[first] + numbers[last] != target) {
            if (numbers[first] + numbers[last] > target) { 
                last--;
            } else {
                first++;
            }
        }
        return new int[]{first + 1, last + 1};
    }
}
