"
Runtime: 358 ms, faster than 7.96% of Java online submissions for Beautiful Arrangement.
Memory Usage: 65.9 MB, less than 5.08% of Java online submissions for Beautiful Arrangement.
"

class Solution {
    
    int result = 0;
    public int countArrangement(int n) {
        if (n < 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        helper(n, list, new HashSet<Integer>());
        return result;
    }
    
    private void helper(int size, List<Integer> list, HashSet<Integer> hashSet){
        if (list.size() == size + 1) {
            result++;
            return;
        }
        for (int i = 1; i <= size; i++) {
            if (hashSet.contains(i)) {
                continue;
            }
            if (list.size() % i == 0 || i % list.size() == 0) {
                list.add(i);
                hashSet.add(i);
                helper(size, list, hashSet);
                hashSet.remove(i);
                list.remove(list.size() - 1);
            }
        }
    }
}