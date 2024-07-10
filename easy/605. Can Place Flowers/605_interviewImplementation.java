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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Can place " + n1 + " flowers in flowerbed1? " + solution.canPlaceFlowers(flowerbed1, n1)); // Expected: true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Can place " + n2 + " flowers in flowerbed2? " + solution.canPlaceFlowers(flowerbed2, n2)); // Expected: false

        int[] flowerbed3 = {0, 0, 1, 0, 0, 0, 1};
        int n3 = 2;
        System.out.println("Can place " + n3 + " flowers in flowerbed3? " + solution.canPlaceFlowers(flowerbed3, n3)); // Expected: true
    }
}
