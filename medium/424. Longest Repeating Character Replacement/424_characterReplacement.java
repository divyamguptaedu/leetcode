"
Performance:
Runtime: 6 ms, faster than 87.89% of Java online submissions for Longest Repeating Character Replacement.
Memory Usage: 43.5 MB, less than 45.39% of Java online submissions for Longest Repeating Character Replacement.
"

class Solution {
    public int characterReplacement(String s, int k) {       
        if (s.length() == 1) {
            return 0;
        }
        int[] array = new int[26];        
        int count = 0;
        int start = 0;
        int size = 0;
        for (int end = 0; end < s.length(); end++){            
            int index = s.charAt(end) - 'A';            
            array[index]++;
            count = Math.max(count, array[index]);
            while(end-start + 1 - count > k){
                array[s.charAt(start) - 'A']--;
                start++;
            }
            size = Math.max(size, end - start + 1);
        }
        return size;        
    }
}