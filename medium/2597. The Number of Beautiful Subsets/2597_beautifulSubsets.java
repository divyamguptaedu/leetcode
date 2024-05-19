//I sorted the array and used backtracking to count beautiful subsets. 
//I maintained a frequency map to track occurrences of numbers in the current subset. 
//For each number, I checked if including it would violate the beautiful subset condition by ensuring no existing number 
//in the subset had an absolute difference of k with it. 
//If valid, I incremented the count, added the number to the subset, 
//and recursively processed the next elements. After backtracking, 
//I removed the number from the frequency map to explore other combinations. 
//This approach allowed me to explore all potential subsets and count the valid ones.

//Time: O(2^n * n)
//Space: O(n) recursion stack

class Solution {
    int[] freqMap;
    int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        freqMap = new int[1001];
        backtracking(0, nums, k, freqMap);
        return count;
    }

    private void backtracking(int index, int[] nums, int k, int[] freqMap) {
        for (int j = index; j < nums.length; j++) {
            if (nums[j] > k && freqMap[nums[j] - k] > 0) { //nums[j] > k is a optimization thing, not a requirement
                continue;
            }
            freqMap[nums[j]]++;
            count++;
            backtracking(j + 1, nums, k, freqMap);
            freqMap[nums[j]]--; //remove for backtrack
        }
    }
}
