//I used a two-phase approach. First, I iterated through s1 to locate all characters of s2 in order, 
//marking the end of a potential window. Then, from the end of this window, 
//I traced back to find the start of the window by matching s2 characters in reverse order. 
//This backward pass ensured that I identified the smallest possible window. 
//If the current window was smaller than the previously found ones, I updated the result. 
//I repeated this process until no more matching windows could be found.

//Time: O(nm^2) where n is the length of s1, and m is the length of s2.
//Space: O(m)
class Solution {
    public String minWindow(String s1, String s2) {
        char[] s2c = s2.toCharArray();
        int s2LastIdx = s2c.length - 1;
        int i = -1;
        int resultPos = 0;
        int resultLen = Integer.MAX_VALUE;
        // Loop through s1 until no more substrings found.
        while (true) {
            // Search forward.
            for (char c : s2c)
                if ((i = s1.indexOf(c, i + 1)) < 0)
                    return (resultLen == Integer.MAX_VALUE) ? "" : s1.substring(resultPos, resultPos + resultLen);
            i++;
            int index = i;
            // Search backward from end of forward result.
            for (int j = s2LastIdx; j >= 0; j--)
                i = s1.lastIndexOf(s2c[j], i - 1);
            // If shorter substring.
            if (index - i < resultLen) {
                resultLen = index - i;
                resultPos = i;
            }
        }
    }
}