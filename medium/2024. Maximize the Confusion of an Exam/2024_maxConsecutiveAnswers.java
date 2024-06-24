//I used a sliding window approach to find the maximum number of consecutive 'T's or 'F's by allowing at most k changes. 
//I iterated through the answer key while maintaining a count of each character within the current window. 
//I tracked the maximum count of any single character in the window. 
//If the difference between the window size and this maximum count exceeded k, 
//I shrank the window from the left. 
//This ensured that at most k changes were needed to make the window homogeneous.
//Time: n
//Space: constant
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] answerArray = answerKey.toCharArray();
        int maxConsecutiveAnswers = 0, maxCount = 0;
        // Array to keep count of characters within the current window
        char[] charCount = new char[128];

        for (int i = 0; i < answerArray.length; i++) {
            // Increment the count of the current character
            maxCount = Math.max(maxCount, ++charCount[answerArray[i]]);
            
            // Check if the number of changes needed exceeds k
            if (maxConsecutiveAnswers - maxCount < k) {
                maxConsecutiveAnswers++;
            } else {
                // Shrink the window from the left if too many changes are needed
                charCount[answerArray[i - maxConsecutiveAnswers]]--;
            }
        }
        return maxConsecutiveAnswers;
    }
}