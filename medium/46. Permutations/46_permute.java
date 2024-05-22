//The approach I used is backtracking to find all possible permutations of distinct 
//integers in the array. I start with an empty list and recursively build permutations 
//by adding each element from the input array that hasn't been used yet. When the current 
//list size equals the length of the input array, it means a permutation is complete, so I 
//add it to the answer list. I explore all possible combinations, ensuring each integer is 
//used exactly once in every permutation. Finally, I return the list of all permutations found.

//Time: O(n*n!)
//Space: O(n*n!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}