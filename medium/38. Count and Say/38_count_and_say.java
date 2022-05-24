"""
Performance:
Runtime: 2 ms, faster than 97.61% of Java online submissions for Count and Say.
Memory Usage: 40 MB, less than 91.80% of Java online submissions for Count and Say.
"""

class Solution {
     public String countAndSay(int n) {
        String value = "1";
        int incrementer = 1;
        while (incrementer++ < n){
            value = countAndSay(value);
        }
        return value;
    }

    private String countAndSay(String value) {
        int incrementer = 0;
        char temp = value.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (char item : value.toCharArray()) {
            if (temp == item) {
                incrementer++;
            } else {
                stringBuilder.append(incrementer);
                stringBuilder.append(temp);
                incrementer = 1;
                temp = item;
            }
        }
        stringBuilder.append(incrementer);
        stringBuilder.append(temp);

        return String.valueOf(stringBuilder);
    }
}