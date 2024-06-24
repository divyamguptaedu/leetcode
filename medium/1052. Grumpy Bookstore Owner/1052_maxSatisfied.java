//Using a sliding window approach, I initially calculated the number of customers that 
//were not satisfied (due to grumpiness) within a window of minutes minutes. 
//By sliding this window across the array of customers and grumpiness indicators, 
//I tracked and updated the maximum number of unsatisfied customers.
//After identifying the maximum number of unsatisfied customers, 
//I added the number of satisfied customers during non-grumpy minutes to this maximum value. 
//This approach ensures that I find the optimal number of satisfied customers by 
//leveraging a single-use secret technique to minimize grumpiness.
//Time: n
//Space: constant
class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unrealizedCustomers = 0;

        // Calculate initial number of unrealized customers in first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unrealizedCustomers += customers[i] * grumpy[i];
        }

        int maxUnrealizedCustomers = unrealizedCustomers;

        // Slide the 'minutes' window across the rest of the customers array
        for (int i = minutes; i < n; i++) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unrealizedCustomers += customers[i] * grumpy[i];
            unrealizedCustomers -= customers[i - minutes] * grumpy[i - minutes];

            // Update the maximum unrealized customers
            maxUnrealizedCustomers = Math.max(
                    maxUnrealizedCustomers,
                    unrealizedCustomers);
        }

        // Start with maximum possible satisfied customers due to secret technique
        int totalCustomers = maxUnrealizedCustomers;

        // Add the satisfied customers during non-grumpy minutes
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }

        // Return the maximum number of satisfied customers
        return totalCustomers;
    }
}