//I computed all possible results from grouping numbers and operators in an expression. 
//In diffWaysToCompute method, I utilized memoization to optimize by caching results for previously computed expressions in the map. 
//I iterated through the expression, identifying operators. 
//For each operator, I recursively computed the left and right expressions, 
//then combined them based on the operator. If no operator exists, 
//I added the parsed integer value to the result list. The hasOperator method checks if an expression contains operators. 
//This approach efficiently computes all possible results using a divide and conquer strategy.

//Time: O(n^3)
//Space: O(n^3)

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // Call the helper method with memoization
        return diffWaysToCompute(expression, new HashMap<>());
    }

    private List<Integer> diffWaysToCompute(String expression, Map<String, List<Integer>> map) {
        // If the result for the current expression is already computed, return it
        if (map.containsKey(expression))
            return map.get(expression);

        // List to store computed values for the current expression
        var values = new ArrayList<Integer>();

        // If there are no operators, parse the expression as integer and add it to the list
        if (!hasOperator(expression)) {
            values.add(Integer.parseInt(expression));
        } else {
            // Iterate through the expression to find operators
            for (var i = 0; i < expression.length(); i++) {
                var symbol = expression.charAt(i);

                // If the character is an operator
                if (!Character.isDigit(symbol)) {
                    // Recursively compute left and right expressions
                    var left = diffWaysToCompute(expression.substring(0, i), map);
                    var right = diffWaysToCompute(expression.substring(i + 1), map);
                    // Combine results based on the operator and add to the values list
                    for (var l : left) {
                        for (var r : right) {
                            switch (symbol) {
                                case '+' -> values.add(l + r);
                                case '-' -> values.add(l - r);
                                case '*' -> values.add(l * r);
                            }
                        }
                    }
                }
            }
        }

        // Cache the computed values for the current expression
        map.put(expression, values);
        return values;
    }

    // Helper method to check if the expression contains an operator
    private boolean hasOperator(String expression) {
        for (var i = 0; i < expression.length(); i++)
            switch (expression.charAt(i)) {
                case '+', '-', '*' -> {
                    return true;
                }
            }
        return false;
    }
}
