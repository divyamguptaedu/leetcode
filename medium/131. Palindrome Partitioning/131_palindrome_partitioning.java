"""
Performance:
Runtime: 20 ms, faster than 33.69% of Java online submissions for Palindrome Partitioning.
Memory Usage: 192.6 MB, less than 45.10% of Java online submissions for Palindrome Partitioning.
"""

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        palindromePartition(s, 0, temp, result);
        return result;
    }
    
    public void palindromePartition(String s, int index, List<String> temp, List<List<String>> result){
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)){
                temp.add(s.substring(index, i + 1));
                palindromePartition(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}