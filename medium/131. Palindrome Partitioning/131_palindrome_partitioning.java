//I used a backtracking approach to find all possible palindrome partitions of the string. 
//Starting from the beginning of the string, I iteratively generated all possible substrings. 
//For each substring, I checked if it was a palindrome using a helper function. 
//If it was, I added the substring to a current list and recursively explored further by advancing the starting index. 
//Once I reached the end of the string, I added the current list of substrings to the result. 
//After exploring each possibility, I backtracked by removing the last added substring to explore other potential partitions.

//Time: O(2^n * n)
//Space: O(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        backtrack(0, result, new ArrayList<String>(), s);
        return result;
    }

    private void backtrack(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length())
            result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                backtrack(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}