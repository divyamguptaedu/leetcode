//To solve the problem of minimizing the number of boats needed to carry people
//with given weights, I sorted the weights and used a two-pointer approach. 
//The heaviest person who can fit with the lightest person is paired first. 
//If the lightest and heaviest together exceed the weight limit, 
//the heaviest person gets their own boat. 
//I incremented the boat count accordingly and continued this process until all 
//people were accounted for.

//Time: NlogN
//Space: logN
class Solution {
    public int numRescueBoats(int[] peopleWeights, int weightLimit) {
        // Sort the array of people weights
        Arrays.sort(peopleWeights);
        // Initialize two pointers and the boat count
        int lightestIndex = 0, heaviestIndex = peopleWeights.length - 1;
        int boatCount = 0;

        // Use a two-pointer approach
        while (lightestIndex <= heaviestIndex) {
            boatCount++;  // Always need one more boat
            // Check if the lightest and heaviest person can share a boat
            if (peopleWeights[lightestIndex] + peopleWeights[heaviestIndex] <= weightLimit)
                lightestIndex++;
            heaviestIndex--;  // Move the pointer for the heaviest person
        }

        return boatCount;  // Return the total number of boats needed
    }
}
