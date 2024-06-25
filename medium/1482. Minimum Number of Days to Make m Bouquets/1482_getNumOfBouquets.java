//First, I defined a helper function to count the number of bouquets that can be 
//made by a given day. In the main function, I set the search range between the 
//minimum and maximum days in the bloomDay array. 
//I used binary search to find the smallest day where we can make at least m bouquets, 
//adjusting the search range based on the number of bouquets that can be made by the 
//midpoint day.
//Time: n log d
//Space: constant
class Solution {

    // Helper function to count the number of bouquets that can be made by a given day
    private int getNumOfBouquets(int[] bloomDay, int day, int k) {
        int numOfBouquets = 0;
        int flowerCount = 0;

        for (int bloom : bloomDay) {
            // If the flower is bloomed by the given day, increase the count
            if (bloom <= day) {
                flowerCount++;
            } else {
                flowerCount = 0;
            }

            // If we have enough flowers to make a bouquet, increase the bouquet count
            if (flowerCount == k) {
                numOfBouquets++;
                flowerCount = 0;
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;

        // Find the maximum day in the bloomDay array
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDays = -1;

        // Perform binary search to find the minimum day
        while (start <= end) {
            int mid = (start + end) / 2;

            // Check if we can make at least m bouquets by the midpoint day
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }
}