//To find the smallest possible integer after removing k digits from a given 
//string representing a non-negative integer, I used a greedy algorithm with a stack. 
//I iterated over each digit in the string, and for each digit, 
//I removed the last digit from the stack if it was larger than the current digit 
//and k was still greater than zero. This ensured that smaller digits were kept 
//for a smaller resultant number. 
//After processing all digits, I removed any remaining digits if k was still 
//greater than zero. Finally, I built the resulting number string while skipping 
//leading zeros.

//Time: n
//Space: n
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string */
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }
}