"
Performance:
Runtime: 3 ms, faster than 84.70% of Java online submissions for Number of Atoms.
Memory Usage: 37.2 MB, less than 92.22% of Java online submissions for Number of Atoms.
"

class Solution {
    Map<String, Integer> result = new TreeMap<>();
    Stack<Integer> stack = new Stack<>();
    int temp = 1;
    
    public String countOfAtoms(String formula) {
        int end = formula.length() - 1;
        int i = formula.length() - 1;
        while (i >= 0) {
            if (formula.charAt(i) == '(') {
                temp = temp / stack.pop();
                i--;
                continue;
            }
            
            end = i;
            int tempTwo = 1;
            
            if (Character.isDigit(formula.charAt(i))) {
                while (Character.isDigit(formula.charAt(i))) i--;
                tempTwo = Integer.parseInt(formula.substring(i+1, end+1));
            } 
            stack.push(tempTwo);
            temp *= tempTwo;
            
            end = i;
            if (Character.isLetter(formula.charAt(i))) {
                while (Character.isLowerCase(formula.charAt(i))) {
                    i--;   
                }
                helper(formula.substring(i, end+1));
            }
            i--;
        }
        
        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            resultString.append(entry.getKey());
            if (entry.getValue() > 1) {
                resultString.append(entry.getValue());
            }
        }
        return resultString.toString();
    }
    
    private void helper(String key) {
        if (result.get(key) == null) {
            result.put(key, temp);
        } else {
            result.put(key, temp + result.get(key));
        }

        temp /= stack.pop();
    }
}