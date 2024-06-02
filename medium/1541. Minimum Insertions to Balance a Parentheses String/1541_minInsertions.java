//I iterated through the string while keeping track of unmatched opening parentheses using 
//countBraces. For every closing parenthesis encountered, I checked if it was followed by 
//another closing parenthesis. If it was, I tried to balance it with an unmatched opening 
//parenthesis. If there was no unmatched opening parenthesis, I increased the count of needed 
//insertions. If a single closing parenthesis was found, I also handled the necessary insertions. 
//At the end, I balanced any remaining unmatched opening parentheses by adding two closing 
//parentheses for each.

//Time: O(n)
//Space: O(1)
class Solution {
    public int minInsertions(String s) {
        int countBraces = 0;  // Tracks unmatched opening parentheses
        int ans = 0;  // Tracks the number of insertions needed
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countBraces += 1;  // Increment for each opening parenthesis
            } else {
                // Check if next character is also a closing parenthesis
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (countBraces > 0) {
                        countBraces--;  // Balance with an opening parenthesis
                    } else {
                        ans += 1;  // Insert an opening parenthesis to balance
                    }
                    i++;  // Skip the next closing parenthesis
                } else {
                    // Single closing parenthesis found
                    if (countBraces > 0) {
                        countBraces--;  // Balance with an opening parenthesis
                        ans += 1;  // Insert one more closing parenthesis
                    } else {
                        ans += 2;  // Insert an opening and a closing parenthesis
                    }
                }
                // Finally we should return the 2times the number of countBraces(opening
                // brackets remaining in excess)
            }
        }
        // Add two closing parentheses for each unmatched opening parenthesis
        return ans + countBraces * 2;
    }
}