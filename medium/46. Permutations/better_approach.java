"""
This solution is inspired by:
https://www.youtube.com/watch?v=KukNnoN-SoY&ab_channel=TimeComplexityInfinity

Performance:
Runtime: 1 ms, faster than 92.63% of Java online submissions for Permutations.
Memory Usage: 39.1 MB, less than 81.23% of Java online submissions for Permutations.
"""

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mainArray = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        for (int x : nums) {
            holder.add(x);
        }
        List<Integer> answer = new ArrayList<>();
        return helper(mainArray, holder, answer);
    }

    private List<List<Integer>> helper(List<List<Integer>> mainArray, List<Integer> holder, List<Integer> answer) {
        if (holder.isEmpty()) {
            mainArray.add(answer);
            return mainArray;
        }
        List<Integer> newHolder;
        List<Integer> newAnswer;
        for (int x : holder) {
            newAnswer = new ArrayList<>();
            for (int a : answer) {
                newAnswer.add(a);
            }
            newAnswer.add(x);
            newHolder = new ArrayList<>();
            for (int y : holder) {
                if (y != x) {
                    newHolder.add(y);
                }
            }
            helper(mainArray, newHolder, newAnswer);
        }
        return mainArray;
    }
}