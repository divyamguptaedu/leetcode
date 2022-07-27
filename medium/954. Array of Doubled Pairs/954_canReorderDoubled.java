"
Performance:
Runtime: 85 ms, faster than 93.08% of Java online submissions for Array of Doubled Pairs.
Memory Usage: 105.9 MB, less than 85.21% of Java online submissions for Array of Doubled Pairs.
"

class Solution {
    public boolean canReorderDoubled(int[] arr) {
     Arrays.sort(arr);
     HashMap<Double,Integer> hashMap = new HashMap<>();
     for (int temp : arr) {
         double x = (double) temp;
         if (hashMap.containsKey(x / 2)) {
             hashMap.put(x / 2, hashMap.get(x / 2) - 1);
             if (hashMap.get(x / 2) == 0) {
                 hashMap.remove(x / 2);
             }
         } else if (hashMap.containsKey(x * 2)) {
             hashMap.put(x * 2, hashMap.get(x * 2) - 1);
             if (hashMap.get(x * 2) == 0) {
                 hashMap.remove(x * 2);
             }
         } else {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
         }
     }
     return hashMap.size() == 0;
    }
}