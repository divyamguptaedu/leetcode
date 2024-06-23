//I used a HashSet to track unique candy types. As I iterated through the candyType array, 
//I added each candy type to the HashSet to ensure uniqueness. After collecting all unique types, 
//I determined the maximum number Alice could eat by taking the minimum of the number of 
//unique types and half the total number of candies (n/2), as advised by the doctor.

//TC: N
//SC: N
class Solution {
    public int distributeCandies(int[] candyType) {
        // Create an empty Hash Set, and add each candy into it.
        Set<Integer> uniqueCandiesSet = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandiesSet.add(candy);
        }
        // Then, find the answer in the same way as before.
        return Math.min(uniqueCandiesSet.size(), candyType.length / 2);
    }
}