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

//Another solution

import java.util.Arrays;

class NewSolution {
    public int calculateScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1 && power < tokens[0]) {
            return 0;
        }
        if (tokens.length == 1 && power > tokens[0]) {
            return 1;
        }
        Arrays.sort(tokens);
        if (tokens[0] > power) {
            return 0;
        }
        int score = 0;
        int max = 0;
        int leftPointer = 0;
        int rightPointer = tokens.length - 1;
        while (leftPointer <= rightPointer) {
            if (power >= tokens[leftPointer]) {
                score++;
                power -= tokens[leftPointer];
                leftPointer++;
            } else {
                if (leftPointer == rightPointer) break;
                else if (power + tokens[rightPointer] >= tokens[leftPointer]) {
                    power += tokens[rightPointer];
                    score--;
                    rightPointer--;
                }
            }
        }
        return score;
    }
}
