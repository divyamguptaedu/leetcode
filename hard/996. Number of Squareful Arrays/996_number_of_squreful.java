"
Performance:
Runtime: 1 ms, faster than 87.80% of Java online submissions for Number of Squareful Arrays.
Memory Usage: 36.1 MB, less than 98.64% of Java online submissions for Number of Squareful Arrays.
"

class Solution {
    int result = 0;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        boolean[] visited = new boolean[A.length];
        helper(A, new ArrayList<>(), visited);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result++;
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!path.isEmpty() && !isSquare(path.get(path.size() - 1), nums[i])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            helper(nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    
    private boolean isSquare(int prev, int current) {
        double sqrt = Math.sqrt(prev + current);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
}