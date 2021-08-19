"
Performance:
Runtime: 1 ms, faster than 91.32% of Java online submissions for String Compression.
Memory Usage: 38.7 MB, less than 68.78% of Java online submissions for String Compression.
"

class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;
        // We traverse the entire array with this iteration.
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i + 1 == chars.length || chars[i] != chars[i+1]) {
                chars[index++] = chars[i];
                // If there are multiple characters, we add the number to the array.
                if (count != 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                // We initialize count to zero for the next character check.
                count = 0;
            }
        }
        return index;
    }
}