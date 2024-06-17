//I iterated through nums1 to populate a map (map1) with the count of each element and 
//determined the maximum value in nums1. For each element in nums2, multiplied by k, 
//I checked if this product was already processed. If not, I iterated through possible multiples of 
//this product up to the maximum value, using map1 to count how many times these 
//multiples appeared in nums1. This count was stored in another map (map2). I then accumulated the 
//results from map2 for each element in nums2 to get the total number of good pairs.

//Time: n + (m * log(max in nums1) where n is the len of nums1, m is len of nums2.
//Space: n + m
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int max = 1;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            max = Math.max(max, num);
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>(); // given a num in nums2 -> total number of good pairs
        long res = 0;
        for (int num : nums2) { // O(n)
            num *= k;
            if (!map2.containsKey(num)) {
                int t = max / num;
                int count = 0;
                for (int i = 1; i <= t; i++) { // avg O(max_num / num)
                    count += map1.getOrDefault(num * i, 0);
                }
                map2.put(num, count);
            }
            res += map2.get(num);
        }

        return res;
    }
}