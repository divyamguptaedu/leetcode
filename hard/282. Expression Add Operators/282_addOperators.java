//I recursively generate all possible expressions by inserting operators between digits of the given number string. 
//I start with the first digit and explore all possible combinations of operators and operands while evaluating each expression. 
//If the current expression evaluates to the target value, I add it to the result list. 
//I use backtracking to explore different paths and avoid unnecessary calculations. 
//The key is to handle multiplication differently from addition and subtraction, considering precedence.

//Time: O(4^n) where n is the length of the input string and for each digit, we have 4 operations, add, sub, mult, or no operator.
//Space" O(n)

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        // Call the recursive function to generate expressions
        generateExpressions(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void generateExpressions(String num, int target, int index, long currentEval, long prevNum, String expression, List<String> result) {
        // Base case: when all digits are processed
        if (index == num.length()) {
            // If the current expression evaluates to the target, add it to the result list
            if (currentEval == target) {
                result.add(expression);
            }
            return;
        }
        // Loop through all possible positions to split the string
        for (int i = index; i < num.length(); i++) {
            // Skip if the current number starts with 0 but is not 0 itself
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            // Get the current number
            long currentNum = Long.parseLong(num.substring(index, i + 1));
            // Handle the first number separately
            if (index == 0) {
                generateExpressions(num, target, i + 1, currentNum, currentNum, expression + currentNum, result);
            } else {
                // Recursively generate expressions for addition, subtraction, and multiplication
                generateExpressions(num, target, i + 1, currentEval + currentNum, currentNum, expression + "+" + currentNum, result);
                generateExpressions(num, target, i + 1, currentEval - currentNum, -currentNum, expression + "-" + currentNum, result);
                generateExpressions(num, target, i + 1, currentEval - prevNum + prevNum * currentNum, prevNum * currentNum, expression + "*" + currentNum, result);
            }
        }
    }
}
