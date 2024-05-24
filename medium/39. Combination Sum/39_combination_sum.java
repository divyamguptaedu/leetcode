//Backtracking solution
//I defined a recursive function that builds combinations of numbers incrementally, checking if they sum to the target. 
//If a combination sums to the target, I add it to the results. 
//If it exceeds the target, I stop exploring that path. 
//At each step, I add a candidate number to the current combination and recursively call the function with the updated sum 
//and combination. If a path fails, I backtrack by removing the last added number and trying the next candidate. 
//This process continues until all combinations are explored.

//Time: O(N^(T/M + 1)) where n is the number of candidates, t is the target value, m is the minimal value among the candidates.
//T/M represents the maximum depth in worst case. adding 1 means adding root which makes it the number of nodes in the tree.

//Space: O(T/M)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
    protected void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }
}