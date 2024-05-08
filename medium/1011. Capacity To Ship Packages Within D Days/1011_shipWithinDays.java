//To solve this question, we can use the binary search approach. But, first we need to find the min and max value of the ships we need.
//So, the min can be the maximum weight on the belt, and the max can be the totalSum of the array.
//Once we have the left and right, we can start the binary search. We get the mid, check if it is feasible. 
//The way we check if its feasible will just be to basically check if the number of days needed with the mid capacity is less or eq to given days or not.
//So, if feasible, then we chose the left half to see if there is a lower value which works. 
//If not, we chose the right half. In the end, we return the left index, which will be the lowest capacity.

//Time: O(nlogn)
//Space: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0;
        int maxLoad = 0;
        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }

        int l = maxLoad;
        int r = totalLoad;

        while (l < r) {
            int mid = (l + r) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // Check whether the packages can be shipped in less than "days" days with
    // "c" capacity.
    Boolean feasible(int[] weights, int c, int days) {
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > c) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }
}