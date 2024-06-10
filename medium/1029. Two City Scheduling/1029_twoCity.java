//I sorted the costs array based on the difference between the cost of sending each person
//to city A and city B. This allowed me to prioritize sending people to the cheaper city
//first. After sorting, I sent the first half of the people to city A and the second half
//to city B. This ensured that exactly n people were sent to each city while minimizing
//the total cost.

//For input:  [[10,20],[30,200],[400,50],[30,20]]
//Sorted list will be [[30, 200], [10, 20], [30, 20], [400, 50]]

//Time: nlogn
//Space: log n: space used by sorting in java
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort the array by the difference in costs between city A and city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                return (person1[0] - person1[1]) - (person2[0] - person2[1]);
            }
        });

        int totalCost = 0;
        int n = costs.length / 2; // Half the number of people
        
        // Send the first half to city A and the second half to city B
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0]; // Cost for city A
            totalCost += costs[i + n][1]; // Cost for city B
        }
        
        return totalCost; // Return the total minimum cost
    }
}
