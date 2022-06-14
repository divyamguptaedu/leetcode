"
Performance:
Runtime: 0 ms, faster than 99.03% of Java online submissions for Largest Divisible Subset.
Memory Usage: 41.6 MB, less than 44.97% of Java online submissions for Largest Divisible Subset.
"

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] matrix = new int[nums.length];
        int[] temp = new int[nums.length];
        int x = 0;
        int y = -1;
        for (int i = 0; i < nums.length; i++) {
            matrix[i] = 1;
            temp[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (matrix[i] < matrix[j] + 1) {
                        matrix[i] = 1 + matrix[j];
                        temp[i] = j;
                    }
                }
            }
            if (x < result[i]) {
                x = result[i];
                y = i;
            }
        }
        List<Integer> result = new LinkedList<>();
        result.add(nums[y]);
        while(temp[y] != y) {
            y = temp[y];
            result.add(nums[y]);
        }
        return result;
    }
}