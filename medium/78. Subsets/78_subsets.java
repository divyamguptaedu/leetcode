"""
Performance:
Runtime: 1 ms, faster than 54.31% of Java online submissions for Subsets.
Memory Usage: 39.1 MB, less than 81.59% of Java online submissions for Subsets.
"""

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        result.add(answer);
        
        for (int newElement : nums) {
            List<List<Integer>> newAnswers = new ArrayList<>();
            
            List<Integer> tempArray;
            for (List<Integer> ans : result) {
                tempArray = new ArrayList<>();
                for (Integer x : ans) {
                    tempArray.add(x);
                }
                tempArray.add(newElement);
                
                newAnswers.add(tempArray);
            }
            
            for (List<Integer> newAddition : newAnswers) {
                result.add(newAddition);
            }
        }
        return result;
    }
}