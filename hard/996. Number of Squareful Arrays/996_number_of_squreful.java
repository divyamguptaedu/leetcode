//I sorted the array and used backtracking to generate permutations, ensuring that adjacent elements fulfill the squareful condition. 
//I checked if the sum of adjacent elements was a perfect square using a helper function. 
//During permutation generation, I avoided duplicate permutations by skipping elements that were equal to their predecessors. 
//After generating all permutations, I incremented a counter to track the number of valid permutations and 
//returned it as the final result.

//Time: O(n!)
//Space: O(n) recursion stack

class Solution {
    int res = 0;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        perms(0, nums);
        return res;
    }

    public void perms(int pos, int nums[]) {
        if (pos == nums.length) { //reached end add to result and backtrack
            res++;
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && (nums[i] == nums[pos] || nums[i] == nums[i - 1])) { //if duplicate
                continue;
            }
            swap(pos, i, nums);
            if ((pos == 0) || isSquare(nums[pos], nums[pos - 1])) {
                perms(pos + 1, nums);
            }
            swap(pos, i, nums); //again for backtracking
        }
    }

    public boolean isSquare(int a, int b) {
        int x = a + b;
        double sqrt = Math.sqrt(x);
        if (sqrt - (int) sqrt == 0) {
            return true;
        }
        return false;
    }

    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}