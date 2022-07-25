"
Performance:
Runtime: 1 ms, faster than 99.26% of Java online submissions for Validate Stack Sequences.
Memory Usage: 45.5 MB, less than 31.77% of Java online submissions for Validate Stack Sequences.
"

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < pushed.length) {
            if (result >= 0 && pushed[result] == popped[j]) {
                result--;
                j++;
            } else {
                i++;
                result++;
                if (i < pushed.length) {
                    pushed[result] = pushed[i];
                }
            }
        }
        
        return result==0;
    }
}