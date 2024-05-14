//Keep track of the balance of the string: the number of '(''s minus the number of ')''s. 
//A string is valid if its balance is 0, plus every prefix has non-negative balance.
//Now, consider the balance of every prefix of S. 
//If it is ever negative (say, -1), we must add a '(' bracket. 
//Also, if the balance of S is positive (say, +B), we must add B ')' brackets at the end.

//Time: O(n)
//Space: O(1)
class Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int balance = 0;
        for (int i = 0; i < S.length(); i++) {
            balance += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed balance >= -1
            if (balance == -1) {
                ans++;
                balance++;
            }
        }

        return ans + balance;
    }
}