//This problem is easy than it seems, it can be boiled down to a sliding window problem.
//We just have an array of integers and we just need to find the continuous subarray that has only two types of elements
//and return the maxSum of such a subarray
//So, we can use a hashmap to keep track of the number of each type of fruit.
//We can use the sliding window and keep track of the maxPicked as well.
//We slide the right pointer, update the map, then check if the current window has more than 2 types.
//If yes, we remove fruit from the left until the window is valid.
//And we keep the max value of the total sum.

//Time: O(n)
//Space: O(n)
class Solution {
    public int totalFruit(int[] fruits) {
        // We use a hash map 'basket' to store the number of each type of fruit.
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxPicked = 0;
        
        // Add fruit from the right index (right) of the window.
        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If the current window has more than 2 types of fruit,
            // we remove fruit from the left index (left) of the window,
            // until the window has only 2 types of fruit.
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }
            
            // Update maxPicked.
            maxPicked = Math.max(maxPicked, right - left + 1);
        }
        
        // Return maxPicked as the maximum number of fruits we can collect.
        return maxPicked;
    }
}