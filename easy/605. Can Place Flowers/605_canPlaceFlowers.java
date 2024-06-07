//I iterated through the flowerbed array, checking if each plot was empty
//and if it could accommodate a flower without violating the no-adjacent-flowers rule.
//For a plot to be suitable, it needed to be empty, and both its neighboring plots
//(if they existed) also had to be empty. If the plot was suitable,
//I planted a flower there and decremented the count of flowers needed.
//After iterating through the flowerbed, I checked if all required flowers were planted.

//Time: m where m is the len of the flowerbed
//Space: 1
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Iterate through each plot in the flowerbed
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty and the adjacent plots (if any) are also
            // empty or out of bounds
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; // Plant a flower
                n--; // Decrement the count of flowers needed
            }
        }
        return n <= 0; // Return true if all required flowers are planted, false otherwise
    }
}