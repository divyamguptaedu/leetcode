// Q1: Given a string with duplicate characters sequence, return the maximum length duplicate contiguous characters
// 'aaaabbbbccc' => ['a','b']
// 'abcd' => ['a','b','c','d']

import java.util.ArrayList;
import java.util.List;

public class MaxLengthDuplicateChars {
    public static List<Character> maxLengthDuplicate(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Character> result = new ArrayList<>();
        int maxCount = 0;
        int currentCount = 1;
        char currentChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == currentChar) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    result.clear();
                    result.add(currentChar);
                } else if (currentCount == maxCount) {
                    result.add(currentChar);
                }
                currentChar = ch;
                currentCount = 1;
            }
        }

        // Final check after loop ends
        if (currentCount > maxCount) {
            result.clear();
            result.add(currentChar);
        } else if (currentCount == maxCount) {
            result.add(currentChar);
        }

        return result;
    }

    public static void main(String[] args) {
        String input1 = "aaaabbbbccc";
        String input2 = "abcd";

        List<Character> result1 = maxLengthDuplicate(input1);
        List<Character> result2 = maxLengthDuplicate(input2);

        System.out.println("Max length duplicate characters in " + input1 + ": " + result1);
        System.out.println("Max length duplicate characters in " + input2 + ": " + result2);
    }
}
