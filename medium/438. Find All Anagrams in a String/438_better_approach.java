"""
Performance:
Runtime: 6 ms, faster than 90.06% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 40.3 MB, less than 26.69% of Java online submissions for Find All Anagrams in a String.
"""

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        int[] listOne = new int[26];
        int[] listTwo = new int[26];
        List<Integer> array = new ArrayList<>();
        
        if (s.length() < p.length()) {
            return array;
        }
        
        for (int i = 0; i < p.length(); i++) {
            listOne[s.charAt(i) - 'a']++;
            listTwo[p.charAt(i) - 'a']++;
        }
     
        int start = 0;
        int end = p.length();
        
        if (Arrays.equals(listOne, listTwo)) {
            array.add(start);
        }
        
        while (end < s.length()) {
            listOne[s.charAt(start) - 'a']--;
            listOne[s.charAt(end) - 'a']++;
            if (Arrays.equals(listOne, listTwo)) {
                array.add(start + 1);  
            }
            start++;
            end++;
        }

        return array;  
    }

}