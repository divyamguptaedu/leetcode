"
Performance:
Runtime: 3 ms, faster than 88.69% of Java online submissions for Letter Case Permutation.
Memory Usage: 54 MB, less than 50.88% of Java online submissions for Letter Case Permutation.
"

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s.toCharArray(), 0, result);
        return result;
    }

    private void helper(char[] current, int start, List<String> result) {
        if (current.length == start) {
            result.add(String.valueOf(current));
            return;
        }
        if (Character.isDigit(current[start])) {
            helper(current, start + 1, result);
        } else {
            current[start] = Character.toUpperCase(current[start]);
            helper(current, start + 1, result);
            current[start] = Character.toLowerCase(current[start]);
            helper(current, start + 1, result);
        }
    }
}