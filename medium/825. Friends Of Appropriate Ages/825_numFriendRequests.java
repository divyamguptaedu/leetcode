class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int answer = 0;
        int[] count = new int[121];
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = i - 1;
            int result = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (0.5 * ages[i] + 7.0 >= ages[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    result = mid;
                }
            }
            if (result != -1) {
                answer += (i - result); 
                answer += count[ages[i]];
            }
            count[ages[i]]++;
        }
        return answer;
    }
}