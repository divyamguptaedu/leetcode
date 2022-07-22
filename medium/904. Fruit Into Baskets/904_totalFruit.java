"
Performance:
Runtime: 85 ms, faster than 45.36% of Java online submissions for Fruit Into Baskets.
Memory Usage: 105.8 MB, less than 48.15% of Java online submissions for Fruit Into Baskets.
"

class Solution {
    public static int totalFruit(int[] fruits) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        int result = 1;
        int index = 0;
        int current = 0;
        for (int unit : fruits) {
            current++;
            hashMap.put(unit, hashMap.getOrDefault(unit, 0) + 1);
            while (hashMap.size() > 2) {
                current--;
                int value = hashMap.getOrDefault(fruits[index], 0) - 1;
                if (value <= 0) {
                    hashMap.remove(fruits[index]);
                }
                if (value > 0) { 
                    hashMap.put(fruits[index], value);
                }
                index++;
            }  
            result = Math.max(current, result);
        }
        return result;
    }
}