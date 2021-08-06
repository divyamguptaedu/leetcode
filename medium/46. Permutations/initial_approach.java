"""
Performance:
Runtime: 3 ms, faster than 15.45% of Java online submissions for Permutations.
Memory Usage: 39.6 MB, less than 13.34% of Java online submissions for Permutations.
"""

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mainArray = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> array = new ArrayList<>();
            array.add(nums[0]);
            mainArray.add(array);
            return mainArray;
        }
        if (nums.length == 2) {
            List<Integer> arrayA = new ArrayList<>();
            List<Integer> arrayB = new ArrayList<>();
            arrayA.add(nums[0]);
            arrayA.add(nums[1]);
            arrayB.add(nums[1]);
            arrayB.add(nums[0]);
            mainArray.add(arrayA);
            mainArray.add(arrayB);
            return mainArray;
        }
        List<Integer> tempList;
        int[] tempArray;
        int index;
        for (int i = 0; i < nums.length; i++) {
            tempList = new ArrayList<>();
            tempList.add(nums[i]);
            tempArray = new int[nums.length - 1];
            index = 0;
            for (int x : nums) {
                if (x != nums[i]) {
                    tempArray[index] = x;
                    index++;
                }
            }

            for (List<Integer> a : permute(tempArray)) {
                mainArray.add(combine(tempList, a));
            }
        }
        return mainArray;
    }

    private static List<Integer> combine(List<Integer> first, List<Integer> second) {
        List<Integer> newList = new ArrayList<>();
        for (Integer x : first) {
            newList.add(x);
        }
        for (Integer x : second) {
            newList.add(x);
        }
        return newList;
    }
}