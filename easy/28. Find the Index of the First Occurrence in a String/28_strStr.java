//I checked for an edge case where if needle was empty, I returned 0 immediately. 
//I then determined the lengths of both strings. I iterated through haystack up to the point where there was enough room left for needle to fit. 
//In each iteration, I extracted a substring of the same length as needle and compared it to needle. 
//If they matched, I returned the starting index. If no match was found, I returned -1.
//Time: mn
//Space: constant
class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.length() == 0) {
            return 0;
        }

        // Length of haystack and needle
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Iterate through haystack until there's enough room for needle
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // Check the substring from i to i + needleLen
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i; // Found the needle, return the starting index
            }
        }

        // If we reach here, needle was not found in haystack
        return -1;
    }
}