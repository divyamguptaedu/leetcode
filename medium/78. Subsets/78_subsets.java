//I generated all possible subsets of the given array nums using backtracking. 
//I initialized an empty list output to store the subsets and defined n as the length of nums. 
//Then, I iterated over all possible subset sizes k from 0 to n. 
//For each subset size, I performed backtracking, starting from index first, 
//adding elements to the current subset curr, and recursively exploring the next elements. 
//When the subset reached size k, I added it to the output list. 
//Finally, I returned the output list containing all possible subsets of nums.

//Time: O(N * 2^N)
//Space: O(N)
class Solution {
    List<List<Integer>> output = new ArrayList();
    int n;
    int k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // If the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            // Add i into the current combination
            curr.add(nums[i]);
            // Use the next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}