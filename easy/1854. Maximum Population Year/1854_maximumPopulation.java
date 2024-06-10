//Check constraints
//I determined the year with the maximum population by using a prefix sum approach.
//I first created an array to record changes in population for each year.
//For each birth year, I incremented the population, and for each death year,
//I decremented the population (since the person is not counted in the death year).
//Then, I calculated the prefix sum to find the total population for each year.
//By iterating through the years, I tracked the maximum population and the earliest year
//it occurred.

/*
Time Complexity: O(n + y)
O(n): Iterate through each log to update the population changes.
O(y): Calculate the prefix sum and determine the maximum population year, where y is the range of years (100 years from 1950 to 2050).
Space Complexity: O(y)
An array of size 101 is used to track population changes from 1950 to 2050.
*/
class Solution {
    public int maximumPopulation(int[][] logs) {
        // Create an array to track population changes from 1950 to 2050
        int[] yearPopulation = new int[2051];
        
        // For each log, increment the birth year and decrement the death year
        for (int[] log : logs) {
            yearPopulation[log[0]] += 1;  // Increment population at birth year
            yearPopulation[log[1]] -= 1;  // Decrement population at death year
        }
        
        // Initialize variables to track the maximum population and corresponding year
        int maxPopulation = yearPopulation[1950];
        int maxPopulationYear = 1950;

        // Calculate the prefix sum to determine the population for each year
        for (int year = 1951; year < 2051; year++) {
            yearPopulation[year] += yearPopulation[year - 1];  // Calculate prefix sum
            if (yearPopulation[year] > maxPopulation) {
                maxPopulation = yearPopulation[year];  // Update max population
                maxPopulationYear = year;  // Update the year with max population
            }
        }
        
        return maxPopulationYear;  // Return the earliest year with maximum population
    }
}
