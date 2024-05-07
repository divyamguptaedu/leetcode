//To solve this question, we can use binary search. But, because it's a matrix, its going to be a complex modified binary search.
//We first need a range to do binary search on, for this matrix, as its sorted, the min would be top left and max would be bottom right.
//So, we build that range, and do binary search on that. What are we searching for? We will calculate the mid, and then find how many elements
//in the matrix are less than or equal to that middle value. Once we have that count, if that is equal to k, we return, if count < k, we search higher
//if count > k, then we search lower.
//Now, the question is how would we calculate #elements less or eq to mid? For this, we will start from the bottom left
//and we will keep track of smallest number larger than mid and biggest number smaller than or eq to mid. That would be O(n) work, 
//while the binary search part is O(log(max-min)) work. 

//Time: O(N log(max-min)) Binary search on range(min element, max element) would be log(max-min). In each iteration of binary search, we iterate over the matrix, which takes O(n)
//Space: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = (start + end) / 2;
            int[] range = {matrix[0][0], matrix[n - 1][n - 1]};
            int count = this.countLessEqual(matrix, mid, range);
            if (count == k) {
                return range[0];
            }
            if (count < k) {
                start = range[1]; // search higher
            } else {
                end = range[0]; // search lower
            }
        }
        return start;
    }

    private int countLessEqual(int[][] matrix, int mid, int[] range) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1; //start from bottom row
        int col = 0; //start from first col
        while (row >= 0 && col < n) { //while in range
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                range[1] = Math.min(range[1], matrix[row][col]);
                row--;
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                range[0] = Math.max(range[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}