//I approached the problem of determining if string A can be transformed into string B by any 
//number of left rotations of A. First, I checked if the lengths of A and B are equal; 
//if not, they can't be rotations. If both strings are empty, they trivially match. 
//Then, I iterated over all possible starting points (s) for rotations of A. 
//For each starting point, I compared the rotated substring of A with B. 
//If a match is found, I return true. This approach checks all rotations sequentially and 
//returns false if no match is found.

//Time: n^2
//Space: constant
class Solution {
    public boolean rotateString(String A, String B) {
        // Check if lengths are different
        if (A.length() != B.length())
            return false;
        
        // If both strings are empty, they trivially match
        if (A.length() == 0)
            return true;

        // Try all possible rotations of A
        for (int s = 0; s < A.length(); ++s) {
            // Check if the substring of A starting from index s matches B
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s + i) % A.length()) != B.charAt(i))
                    break; // Move to the next rotation
                // If we have checked all characters and they match, return true
                if (i == A.length() - 1)
                    return true;
            }
        }
        
        return false; // No matching rotation found
    }
}
