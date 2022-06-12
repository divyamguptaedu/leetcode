"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
Memory Usage: 39.5 MB, less than 87.39% of Java online submissions for Excel Sheet Column Title.
"""

class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0 ){  
            int a = n % 26; 
            if (a == 0) {       
                a = 26;
                n--;
             }
            result.append((char)(a + 64));
            n/=26;
        }
        return result.reverse().toString();
    }
}