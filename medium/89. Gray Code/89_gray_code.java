"""
Performance: 
Runtime: 20 ms, faster than 20.96% of Java online submissions for Gray Code.
Memory Usage: 54.8 MB, less than 69.39% of Java online submissions for Gray Code.
"""

class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(1);
            return result;
        }
        List<Integer> list =  grayCode(n-1);
        int num = 1 << (n - 1);
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            answer.add(list.get(i));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            answer.add(list.get(i) + num);
        }
        return answer;
    }
}
