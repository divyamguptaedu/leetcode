//We can use a sliding window approach to solve this question. We can first initialize a frequency map.
//We will move the right pointer, add the numbers to the map, will add to the local sum as well.
//When the window length == k, we will check if the size of the map is also k, if yes, we will save the sum.
//Then we can remove the i from the map and the sum and expand both i and j.
//If length not equal to k, we do the same, remove i, increment both i and j.

//Time: O(n)
//Space: O(n)
class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long sum = 0;
        long maxSum = 0;

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1); // add it to map
            sum += arr[j]; // add to local sum
            if (j - i + 1 == k) { // if window length == K
                if (map.size() == k) { // if size of map is k, that means there are k unique elements
                    maxSum = Math.max(maxSum, sum); // take the max sum
                }
                sum -= arr[i]; // remove calculation of arr[i]
                map.put(arr[i], map.get(arr[i]) - 1); // remove arr[i] from map. If arr[i] is duplicate in window,
                                                      // decrease the freq by 1
                if (map.get(arr[i]) == 0)
                    map.remove(arr[i]);
                i++; // shift the window to the right
            }
            j++; // expand the window
        }

        return maxSum;
    }
}