//I used a HashMap to store the maximum number for each possible digit sum. As I iterated through the array, 
//I calculated the digit sum for each number and checked if there was already a number with the same digit sum in the map. 
//If so, I updated the maximum result with the sum of the current number and the number in the map. 
//I also updated the map with the maximum of the current number and the existing number for that digit sum.
//Time: n where n is #elements in array
//Space: m where m is #uniqueDigitSums
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for (int item : nums) {
            int key = getNumberTotal(item);

            if (!map.containsKey(key))
                map.put(key, item);
            else {
                result = Math.max(result, map.get(key) + item);
                map.put(key, Math.max(map.get(key), item));
            }
        }

        return result;
    }

    int getNumberTotal(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }
}