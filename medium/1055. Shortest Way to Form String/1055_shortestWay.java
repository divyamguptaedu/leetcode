//I approached the problem of finding the minimum number of subsequences of source 
//that can concatenate to form target using a greedy approach. 
//Starting from the beginning of target, 
//I attempt to match characters by iterating through source. 
//If a character in source matches the current character in target, 
//I move to the next character in target. 
//If I can't match a character in target using source, 
//it indicates that forming target is impossible with source.

//Time: mn where m is the len of source and n is len of target
//Space: m+n
class Solution {
    public int shortestWay(String source, String target) {
        char[] src = source.toCharArray();
        char[] tgt = target.toCharArray();

        int subsequenceCount = 0;
        int targetIndex = 0;

        while (targetIndex < tgt.length) {
            int index = findSubsequenceEnd(src, 0, tgt, targetIndex);
            if (index == targetIndex) {
                return -1; // Impossible to form target
            }
            targetIndex = index; // Move to the next unmatched character in target
            subsequenceCount++;
        }

        return subsequenceCount;
    }

    private int findSubsequenceEnd(char[] src, int startIndex, char[] tgt, int targetIndex) {
        while (startIndex < src.length && targetIndex < tgt.length) {
            if (src[startIndex] == tgt[targetIndex]) {
                targetIndex++; // Move to the next character in target
            }
            startIndex++; // Always move to the next character in source
        }
        return targetIndex;
    }
}