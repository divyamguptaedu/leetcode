"
Performance:
Runtime: 2 ms, faster than 66.51% of Java online submissions for Additive Number.
Memory Usage: 41.9 MB, less than 63.47% of Java online submissions for Additive Number.
"

class Solution {
    
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2) {
            return false;
        }
        for (int i = 0; i < (num.length() - 1) / 2; i++) {
            for (int j = i + 1; num.length() - j - 1 >= Math.max(i + 1, j - i); j++) {
                if (helper(num.substring(0, i + 1), num.substring(i + 1, j + 1), num.substring(j + 1)))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(String numOne, String numTwo, String left) {
        if (left.isEmpty()) {
            return true;
        }
        if (numOne.charAt(0) == '0' && numOne.length() > 1) {
            return false;
        }
        if (numTwo.charAt(0) == '0' && numTwo.length() > 1) {
            return false;
        }
        String total = String.valueOf(Long.parseLong(numOne) + Long.parseLong(numTwo));
        if (!left.startsWith(total)) {
            return false;
        }
        return helper(numTwo, total, left.substring(total.length()));
    }
}