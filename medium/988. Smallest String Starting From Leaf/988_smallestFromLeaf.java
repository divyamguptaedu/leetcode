//I iterated through both interval lists using two pointers. 
//For each pair of intervals, I calculated the intersection by 
//taking the maximum of their start points and the minimum of their end points. 
//If this intersection was valid (the start was less than or equal to the end), 
//I added it to the result list. After checking each pair, 
//I advanced the pointer of the interval that ended first, 
//ensuring I considered all possible intersections. 
//Finally, I converted the list of results into an array and returned it.

//Time: O(m+n) where m and n are the lengths of A and B.
//Space: O(m+n)
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();  // Initialize the list to store the intersections
        int i = 0;  // Pointer for the first list
        int j = 0;  // Pointer for the second list

        while (i < A.length && j < B.length) {
            // Calculate the intersection start point (lo) and end point (hi)
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)  // If it's a valid intersection
                ans.add(new int[] { lo, hi });  // Add to the result list

            // Advance the pointer of the interval that ends first
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        // Convert the list of intersections to an array and return
        return ans.toArray(new int[ans.size()][]);
    }
}
