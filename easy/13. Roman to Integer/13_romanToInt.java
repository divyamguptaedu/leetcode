//I iterate over the Roman numeral string from right to left. 
//I assign numerical values to each symbol and accumulate the result. 
//If the current value is smaller than four times the previous value, 
//I subtract it; otherwise, I add it. This approach ensures correct handling of subtraction cases like IV (4) and IX (9). 
//For each character in the string, I retrieve its corresponding numerical value and 
//check if subtraction is needed based on its magnitude compared to the previous character.
//Finally, I return the accumulated result.

//Time: O(n) n is the length of s
//Space: O(1)

class Solution {
    public int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}