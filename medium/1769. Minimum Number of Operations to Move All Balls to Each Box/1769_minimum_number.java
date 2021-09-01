"
Performance:
Runtime: 162 ms, faster than 39.98% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
Memory Usage: 39.3 MB, less than 87.12% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
"

class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> list = new ArrayList<>();
        for (char x: boxes.toCharArray()){
            list.add(x -'0');
        }
        int[] result = new int[boxes.length()];
        for (int i = 0;i < list.size(); i++) {
            int answer = 0;
            for (int j = 0;j < list.size(); j++) {
                if(i != j){
                    if (list.get(j)==1){
                        answer += Math.abs(i - j);
                    }
                }
            }
            result[i] = answer;
        }
        return result;
    }
}