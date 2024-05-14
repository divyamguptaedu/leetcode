//Used binary search to find the longest common prefix among an array of strings. 
//Initially, it finds the minimum length among all strings. Then, it sets the search range from 1 to the minimum length. 
//Within each iteration, it calculates the middle value and checks if it forms a common prefix among all strings using the isCommonPrefix method. 
//If it does, it updates the lower bound; otherwise, it updates the upper bound. 
//This process continues until the lower bound surpasses the upper bound. 
//Finally, it returns the common prefix found by substringing the first string up to the middle index.

//Time: O(SlogM) where S is the sum of all chars in the all strings, m is the length of the shortest string.
//Space: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2); //substring from 0 to mid, we don't have mid outside of while loop.
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }
}