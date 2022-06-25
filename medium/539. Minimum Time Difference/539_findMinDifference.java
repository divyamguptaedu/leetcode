"
Performance:
Runtime: 33 ms, faster than 18.40% of Java online submissions for Minimum Time Difference.
Memory Usage: 50.2 MB, less than 18.87% of Java online submissions for Minimum Time Difference.
"
class Solution {
    public static int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (String times : timePoints) {
            String[] temp = times.split(":");
            int tempTwo = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            list.add(tempTwo);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            result = Math.min(result, calculateTimeDiff(list.get(i + 1),list.get(i)));
        }
        
        result = Math.min(result,calculateTimeDiff(list.get(list.size() - 1),list.get(0)));
        return result;
    }
    public static int calculateTimeDiff(int maxTime, int minTime){
        int total = 60 * 24;
        int difference = (maxTime - minTime);
        return Math.min(difference, total - difference);
    }

}