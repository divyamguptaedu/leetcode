class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        generateExpressions(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void generateExpressions(String num, int target, int index, long currentEval, long prevNum,
            String expression, List<String> result) {
        if (index == num.length()) {
            if (currentEval == target) {
                result.add(expression);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long currentNum = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                generateExpressions(num, target, i + 1, currentNum, currentNum, expression + currentNum, result);
            } else {
                generateExpressions(num, target, i + 1, currentEval + currentNum, currentNum,
                        expression + "+" + currentNum, result);
                generateExpressions(num, target, i + 1, currentEval - currentNum, -currentNum,
                        expression + "-" + currentNum, result);
                generateExpressions(num, target, i + 1, currentEval - prevNum + prevNum * currentNum,
                        prevNum * currentNum, expression + "*" + currentNum, result);
            }
        }
    }
}