//Runtime: 3 ms, faster than 21.56% of Java online submissions for Excel Sheet Column Number.
//Memory Usage: 42.6 MB, less than 55.61% of Java online submissions for Excel Sheet Column Number.

class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return -1;
        }
        int total = 0;
        for (char letter : columnTitle.toUpperCase().toCharArray()) {
            total *= 26;
            total += letter - 'A' + 1;
        }
        return total;
    }
}