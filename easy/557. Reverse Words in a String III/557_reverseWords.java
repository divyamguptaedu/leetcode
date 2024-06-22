//I approached the problem by converting the input string s into a character array to facilitate in-place 
//modification. I initialized lastSpaceIndex to track the position of the last space encountered. 
//By iterating through each character, I identified word boundaries using spaces. 
//For each word boundary found, I reversed the characters between lastSpaceIndex + 1 and strIndex - 1. 
//This was achieved using a two-pointer technique. After processing all words, 
//I returned the modified character array as a new string.

//Time: n
//Space: n
class Solution {
    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }

}