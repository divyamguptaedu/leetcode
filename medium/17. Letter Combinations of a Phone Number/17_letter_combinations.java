"""
Performance:
Runtime: 4 ms, faster than 43.87% of Java online submissions for Letter Combinations of a Phone Number.
Memory Usage: 39.5 MB, less than 14.34% of Java online submissions for Letter Combinations of a Phone Number.
"""

class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
        	allCombinations(digits, "", result);
        }
        return result;
    }


    private void allCombinations(String digits, String answer, List<String> result) {
    	if (digits.length() == 0) {
    		result.add(answer);
 			return;
    	}

    	char number = digits.charAt(0);
    	String temp = digits.substring(1);
    	String code = digitCode(number);

        // get all combinations;
    	for (int i = 0; i < code.length(); i++) {
    		allCombinations(temp, answer + code.charAt(i), result);
    	}
    }


    // returns the string associated with that number of the phone;
    private String digitCode(char digit) {
    	switch (digit) {
    		case '2' : return "abc";
    		case '3' : return "def";
    		case '4' : return "ghi";
    		case '5' : return "jkl";
    		case '6' : return "mno";
    		case '7' : return "pqrs";
    		case '8' : return "tuv";
    		case '9' : return "wxyz";
    	}
        return "";
    }
}