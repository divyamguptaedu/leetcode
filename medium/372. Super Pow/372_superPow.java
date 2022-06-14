"
Performance:
Runtime: 13 ms, faster than 18.10% of Java online submissions for Super Pow.
Memory Usage: 48 MB, less than 5.17% of Java online submissions for Super Pow.
"

class Solution {
    public int superPow(int a, int[] b) {
        a = a % 1337; 
        if (a <= 1) return a;
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        int value = a;
        int power = 1;
        while (! hashSet.contains(value)) {
            result.put(power, value);
            hashSet.add(value);
            value = (value * a) % 1337;
            power++;
        }
        
        int reminder = 0;
        for (int i = 0; i < b.length; i++) {
            reminder = (reminder * 10 + b[i]) % hashSet.size();
        }
        
        return result.get(reminder);
    }
}