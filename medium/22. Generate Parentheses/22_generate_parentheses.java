//Implemented a backtracking algorithm to generate all combinations of well-formed parentheses. 
//It recursively builds valid strings, ensuring each open parenthesis is matched with a corresponding close parenthesis. 
//It maintains counts of open and close parentheses to ensure validity. 
//The algorithm adds generated strings to the answer list once their length equals 2*n. 

//Time: O(4^n/sqrt(n)) //number of combinations
//Space: O(n) //recursion depth
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, "", 0, 0, n);
        return answer;
    }

    private void backtracking(List<String> answer, String curString, int leftCount, int rightCount, int n) {
        if (curString.length() == 2 * n) {
            answer.add(curString);
            return;
        }
        if (leftCount < n) {
            backtracking(answer, curString + "(", leftCount + 1, rightCount, n);
        }
        if (leftCount > rightCount) {
            backtracking(answer, curString + ")", leftCount, rightCount + 1, n);
        }
    }
}