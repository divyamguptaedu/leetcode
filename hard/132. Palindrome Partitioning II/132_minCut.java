"
Performance:
Runtime: 25 ms, faster than 85.44% of Java online submissions for Palindrome Partitioning II.
Memory Usage: 44 MB, less than 69.33% of Java online submissions for Palindrome Partitioning II.
"
class Solution {
    public int minCut(String s) {
       if (s == null || s.length() == 0 || s.length() == 1) {
           return 0;
       }
       int[] result = new int[s.length()];
       boolean[][] notAnswer = new boolean[s.length()][s.length()];
       notAnswer[0][0] = notAnswer[1][1] = true;
       notAnswer[0][1] = s.charAt(0) == s.charAt(1) ? true : false;
       result[1] = notAnswer[0][1] ? 0 : 1;
       for (int i = 2; i < s.length(); i++) {
           result[i] = result[i - 1] + 1;
           notAnswer[i][i] = true;
           for (int j = 0; j < i; j++) {
               if (s.charAt(i) == s.charAt(j)) {
                   if (j == i - 1) {
                       result[i] = Math.min(result[i], result[i - 2] + 1);
                       notAnswer[i - 1][i] = true;
                   } else if(notAnswer[j + 1][i - 1]) {
                       result[i] = Math.min(result[i], j == 0 ? 0 : (result[j - 1] + 1));
                       notAnswer[j][i] = true;
                   }
               }
           }
       }
       return result[s.length() - 1];
    }
}

