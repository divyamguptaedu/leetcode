//I iterated through the temperatures array from the end to the beginning.
//I kept track of the hottest temperature seen so far. 
//For each day, if the temperature was greater than or equal to the hottest temperature,
//I updated the hottest temperature and continued.
//If not, I checked how many days it took to find a warmer temperature using
//previously calculated results, storing the result in the answer array.

//Time: n
//Space: 1
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int[] daysUntilWarmer = new int[n];

        // Traverse the array from the end to the beginning
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];

            // If current temperature is the hottest seen so far
            if (currentTemp >= hottest) {
                hottest = currentTemp; // Update the hottest temperature
                continue; // No warmer day ahead
            }

            int days = 1; // Initialize the number of days to wait for a warmer temperature
            while (temperatures[currDay + days] <= currentTemp) {
                // Use the answer array to skip unnecessary comparisons
                days += daysUntilWarmer[currDay + days];
            }
            daysUntilWarmer[currDay] = days; // Store the result in the answer array
        }

        return daysUntilWarmer; // Return the result array
    }
}