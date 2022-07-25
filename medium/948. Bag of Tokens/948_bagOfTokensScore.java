"
Performance:
Runtime: 4 ms, faster than 60.14% of Java online submissions for Bag of Tokens.
Memory Usage: 43.3 MB, less than 49.28% of Java online submissions for Bag of Tokens.
"

class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        if (tokens.length == 0 || p < tokens[0]) {
            return 0;
        }
        int score = 0;
        int result = 0;  
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (p < tokens[left]) {
                if (score > 0) {
                    p += tokens[right--];
                    score--;
                } else {
                    return score;
                }
            } else {
                p -= tokens[left++];
                score++;
                result = Math.max(score, result);
            } 
        }
        return result;
    }
}