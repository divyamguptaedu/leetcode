//I determined the contribution of each element being the minimum in its subarrays. 
//First, I calculated the right boundary for each element where the next smaller or equal element appears. 
//Then, I calculated the left boundary where the previous smaller element appears. 
//I used prefix sums to compute the total strengths of subarrays efficiently. 
//By analyzing the left and right boundaries, 
//I derived the subarray sums where each element is the minimum and used these to compute the final result.

//Time: n
//Space: n

//Input: [1,3,1,2]
//rightIndex: [2,2,4,4] //first index of a non-larger value to i's right
//leftIndex: [-1,0,-1,2] //first index of a smaller value to i's left
//prefixSum: [0,0,1,4,5,7]
//prefixSumofPrefixSum: [0,0,1,5,10,17]
//now, final calculation loop
//element.     : 1 | 3 | 1  | 2
//left bound.  : 1 | 0 |-1. | 2
//right bound. : 2 | 2 | 4. | 4
//left count   : 1 | 1 | 3. | 1
//right count. : 2 | 1 | 2  | 1
//neg preSum.  : 0 | 1 | 5. | 5
//pos preSum.  : 5 | 4 | 12 | 7
//answer.      : 5 |+9 |+26 |+4 = total = 44
class Solution {
    public int totalStrength(int[] strength) {
        int mod = (int)1e9 + 7, n = strength.length;
        
        // Get the first index of the non-larger value to strength[i]'s right.
        Stack<Integer> stack = new Stack<>();
        int rightIndex[] = new int[n];
        Arrays.fill(rightIndex, n);
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                rightIndex[stack.pop()] = i;
            }
            stack.add(i);
        }
        
        // Get the first index of the smaller value to strength[i]'s left.
        int leftIndex[] = new int[n];
        Arrays.fill(leftIndex, -1);
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i])
                leftIndex[stack.pop()] = i;
            stack.add(i);
        }

        // Get the prefix sum of the prefix sum array of strength.
        long answer = 0;
        long[] presumOfPresum = new long[n + 2];
        for (int i = 0; i < n; ++i)
            presumOfPresum[i + 2] = (presumOfPresum[i + 1] + strength[i]) % mod;
        for (int i = 1; i <= n; ++i)
            presumOfPresum[i + 1] = (presumOfPresum[i + 1] + presumOfPresum[i]) % mod;
        
        // For each element in strength, we get the value of R_term - L_term.
        for (int i = 0; i < n; ++i) {
            // Get the left index and the right index.
            int leftBound = leftIndex[i], rightBound = rightIndex[i];

            // Get the leftCount and rightCount (marked as L and R in the previous slides)
            int leftCount = i - leftBound, rightCount = rightBound - i;
            
            // Get posPresum and negPresum.
            long negPresum = (presumOfPresum[i + 1] - presumOfPresum[i - leftCount + 1]) % mod;
            long posPresum = (presumOfPresum[i + rightCount + 1] - presumOfPresum[i + 1]) % mod;

            // The total strength of all subarrays that have strength[i] as the minimum.
            answer = (answer + (posPresum * leftCount - negPresum * rightCount) % mod * strength[i] % mod) % mod;
        }

        return (int)(answer + mod) % mod;
    }
}