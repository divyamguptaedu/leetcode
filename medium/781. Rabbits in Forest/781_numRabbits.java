"
Performance:
Runtime: 3 ms, faster than 85.40% of Java online submissions for Rabbits in Forest.
Memory Usage: 41.5 MB, less than 96.15% of Java online submissions for Rabbits in Forest.
"

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int x : answers) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        for (int key : hashMap.keySet()) {
            int keys = key + 1;
            int frequency = hashMap.get(key);
            int temp = (int) Math.ceil((frequency * 1.0) / keys * 1.0);
            count += temp * keys;
        }
        return count;
    }
}