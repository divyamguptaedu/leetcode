//We can solve this question using the binary search approach. We know that the minimum value of k can be 1 and max can be the max bananas in a single pile.
//So, first we find the max bananas in a single pile and then start the binary search.
//We calculate the middle value, and for every middle value, we find the hours that will be spent to finish the piles.
//If that hour value is <= h, then we chose the left half, otherwise, righthalf.
//In the end, we return the right value, which will represent the minimum workable eating speed.

//Time: O(nlogm) Where n is the number of piles, and m is the maximum bananas in a single pile.
//Space: O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}