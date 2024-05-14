//Used recursive backtracking to find all valid expressions by removing the minimum number of invalid parentheses. 
//It tracks the count of misplaced parentheses (left and right) and recursively generates expressions, 
//either by removing misplaced parentheses or including valid ones. 
//Optimization - The algorithm prunes branches by not recursing further if the remaining count for a parenthesis type is zero. 
//So, we will first count this remaining left and right count, and then start our backtrack.
//It builds valid expressions and adds them to a set, ensuring uniqueness. 
//Finally, it returns the list of valid expressions. 

//Time: O(2^n)
//Space: O(n)
class Solution {

    private Set<String> validExpressions = new HashSet<String>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {
            // Simply record the left one.
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                if (left == 0) {
                    right++;
                }
                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                if (left > 0) {
                    left--;
                }
            }
        }

        this.backtrack(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions);
    }

    private void backtrack(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder expression) {
        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions.add(expression.toString());
            }
        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // The 'not take' case
            // Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRem > 0)) {
                this.backtrack(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, expression);
            }
            if ((character == ')' && rightRem > 0)) {
                this.backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, expression);
            }
            
            // The 'take' case
            expression.append(character);
            // Simply recurse one step further if the current character is not a
            // parenthesis.
            if (character != '(' && character != ')') {
                this.backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (character == '(') {
                // Consider an opening bracket.
                this.backtrack(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                // Consider a closing bracket.
                this.backtrack(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }
            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }
}