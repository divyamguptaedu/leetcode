"""
Performance:
Runtime: 33 ms, faster than 23.55% of Java online submissions for Heaters.
Memory Usage: 53.8 MB, less than 66.58% of Java online submissions for Heaters.
"""

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int result = 0;
        for (int i = 0; i < houses.length; i++) {
            int low = 0;
            int high = heaters.length - 1;
            long min = Long.MAX_VALUE;
            while (low <= high) {
                int mid = low - (low - high) / 2;
                long temp = houses[i] - heaters[mid];
                if (Math.abs(temp) < min) {
                    min = Math.abs(temp);

                }
                if(temp > 0) {
                    low = mid + 1; 
                } else {
                    high = mid-1;
                }
            }
            result = Math.max(result,(int) min);
        }
        return result; 
    }
}