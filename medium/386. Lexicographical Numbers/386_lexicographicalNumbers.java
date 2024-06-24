//I approached the problem of generating all numbers in the range [1, n] sorted lexicographically using Depth-First Search (DFS). 
//Starting from 1, I recursively build numbers by appending digits from 0 to 9 to the current number, 
//ensuring they are added in lexicographical order. 
//I skip adding numbers starting with 0 and stop when the constructed number exceeds n. 
//This ensures all numbers are generated in the required order efficiently.
//Time: n
//Space: constant
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(result, n, 0);
        return result;
    }

    private void dfs(List<Integer> result, int n, int current) {
        for (int i = 0; i <= 9; i++) {
            int num = 10 * current + i;
            // Skip numbers starting with 0
            if (num == 0)
                continue;
            // Stop if number exceeds n
            if (num > n)
                return;
            result.add(num);
            dfs(result, n, num);
        }
    }
}
