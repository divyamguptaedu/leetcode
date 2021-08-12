"""
Performance:
Runtime: 18 ms, faster than 86.65% of Java online submissions for 3Sum.
Memory Usage: 43.5 MB, less than 29.40% of Java online submissions for 3Sum.
"""

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            List<Integer> answer;
            while (j < k) {
            	int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                	
                	answer = new ArrayList<>();
                	answer.add(nums[i]);
                	answer.add(nums[j]);
                	answer.add(nums[k]);
                	result.add(answer);

                    // avoid duplicates;
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                // if sum < 0, then let's try next bigger element;
                } else if (sum < 0) {
                    j++;
                    // if sum > 0, then let's try next smaller element;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}