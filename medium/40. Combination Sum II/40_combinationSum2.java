//I sorted the input array to handle duplicates. I used backtracking to build combinations, 
//starting from each index and adding numbers to the current combination. 
//To avoid duplicate combinations, I skipped numbers that were the same as the previous number in the array unless 
//it was the first instance of that number at the current level of recursion. 
//If the current combination’s sum exceeded the target, I stopped exploring further. 
//Once the sum equaled the target, I added the current combination to the results list. 
//Each number in candidates was used at most once in each combination.

//Time: O(2^n) where n is the size of the input array. 
//In worst case our algo will use all possible combinations from the input array, which total will be 2^n combinations. 
//Sorting will take n log n. 2^n dominates.
//Space: O(n)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(candidates, comb, target, 0, results);
        return results;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer curr, List<List<Integer>> results) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
            //skip duplicates
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
                continue;

            Integer pick = candidates[nextCurr];
            // optimization: early stopping
            if (remain - pick < 0)
                break;

            comb.addLast(pick);
            backtrack(candidates, comb, remain - pick, nextCurr + 1, results);
            comb.removeLast();
        }
    }
}