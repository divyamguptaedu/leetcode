//I used dynamic programming to iteratively calculate the minimum cost for each day.
//I initialized an array to store the minimum cost for each day up to the last travel day. 
//Then, I iterated through each day, updating the minimum cost based on 
//the cost of buying a pass on that day or using a pass bought previously. 
//So, we store the cost with the minimum of the three options.

//Time: O(K) K is the last day that we need to travel, i.e. last value in the days array.
//Space: O(K)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0], 
                          Math.min(dp[Math.max(0, day - 7)] + costs[1], 
                                   dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }
}