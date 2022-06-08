"
Runtime: 32 ms, faster than 37.09% of Java online submissions for Longest Word in Dictionary through Deleting.
Memory Usage: 50.8 MB, less than 69.57% of Java online submissions for Longest Word in Dictionary through Deleting.
"

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String tempOne: d) {
            if (tempOne.length() > s.length()) {
                continue;
            }
            int tempTwoPointer = 0;
            int tempOnePointer = 0;
            while (tempTwoPointer < s.length() && tempOnePointer < tempOne.length()) {
                if (s.charAt(tempTwoPointer) == tempOne.charAt(tempOnePointer)) {
                    ++tempOnePointer;
                }
                tempTwoPointer++;
            }
            
            if (tempOnePointer == tempOne.length()) {
                if ((tempOne.length() > result.length()) || (tempOne.length() == result.length() && tempOne.compareTo(result) < 0)) {
                    result = tempOne;
                }
            }
        }
        
        return result;
    }
}