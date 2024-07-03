//I used a mathematical approach to find the k-th symbol in the n-th row of the grammar table. 
//I tracked whether the symbol was flipped by observing the position of k in each row. 
//Starting from the nth row, I determined if k was in the first or second half, halving the row size each time. 
//If k was in the second half, I adjusted k and toggled a flag indicating a flip. 
//I continued this until reaching the first row, where the flag determined the symbol.
//Time: logn
//Space: constant
public class Solution {
    public int kthGrammar(int n, int k) {
        // Initialize a flag to track if the values of k and the first element are the same.
        boolean areValuesSame = true;
        // Calculate the total number of elements in the nth row, which is 2^(n-1).
        n = (int) Math.pow(2, n - 1);
        // Continue until we reach the first row.
        while (n != 1) {
            // Halve the number of elements in the row.
            n /= 2;
            // If k is in the second half of the row, adjust k and toggle the flag.
            if (k > n) {
                k -= n;
                areValuesSame = !areValuesSame;
            }
        }
        // Return 0 if the flag indicates that the values are the same; otherwise,
        // return 1.
        return (areValuesSame ? 0 : 1);
    }
}