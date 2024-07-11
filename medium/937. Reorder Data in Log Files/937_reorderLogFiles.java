// Approach: I iterate over the logs and separate them into letter-logs and digit-logs. I then sort the letter-logs lexicographically by their content, and by their identifier if there is a tie. Finally, I concatenate the sorted letter-logs and the original digit-logs.

// Time Complexity: O(m * n log n) where n is the number of logs in the list and m is the max length of a single log.
// Space Complexity: O(m log m) (in-place sorting)

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String log1, String log2) {
                int l1 = log1.length() - 1;
                int l2 = log2.length() - 1;

                if (Character.isDigit(log1.charAt(l1)) && Character.isDigit(log2.charAt(l2))) {
                    return 0;
                }

                if (Character.isDigit(log1.charAt(l1))) {
                    return 1;
                }
                if (Character.isDigit(log2.charAt(l2))) {
                    return -1;
                }
                int i = log1.indexOf(" ");
                int j = log2.indexOf(" ");
                int val = log1.substring(i + 1).compareTo(log2.substring(j + 1));
                if (val != 0) {
                    return val;
                }

                return log1.compareTo(log2);
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };

        String[] result = solution.reorderLogFiles(logs);

        System.out.println("Reordered logs:");
        for (String log : result) {
            System.out.println(log);
        }
    }
}