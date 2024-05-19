//Memoization to optimize the recursive solution discussed earlier. 
//I cached the results of subproblems in a 2D array called memo. 
//Before computing the result of a subproblem, I checked if it was already cached. 
//If so, I retrieved the cached result; otherwise, I computed it recursively as before. 
//After computing the result, I stored it in memo for future reference. 
//This approach reduced redundant computations by reusing previously computed results, 
//thereby optimizing the overall runtime of the solution.

//Time: O(mn) where m and n are lengths of each word.
//Space: O(mn)
class Solution {
    Integer memo[][]; // Memoization array to store computed results

    // Main function to calculate minimum edit distance
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length() + 1][word2.length() + 1]; // Initialize memoization array
        return minDistanceRecur(word1, word2, word1.length(), word2.length()); // Call recursive function
    }

    // Recursive function to calculate minimum edit distance
    private int minDistanceRecur(String word1, String word2, int word1Index, int word2Index) {
        // Base cases: If either string is empty, return the length of the other string
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        // If result for current subproblem is already computed, return the cached result
        if (memo[word1Index][word2Index] != null) {
            return memo[word1Index][word2Index];
        }
        // Initialize minimum edit distance
        int minEditDistance = 0;
        // If characters at current indices match, move to the next indices
        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            minEditDistance = minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
        } else { // If characters don't match, consider insert, delete, and replace operations
            int insertOperation = minDistanceRecur(word1, word2, word1Index, word2Index - 1);
            int deleteOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index);
            int replaceOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1);
            // Calculate minimum edit distance by considering all operations and adding 1
            minEditDistance = Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1;
        }
        // Cache the computed result for future reference
        memo[word1Index][word2Index] = minEditDistance;
        return minEditDistance;
    }
}
