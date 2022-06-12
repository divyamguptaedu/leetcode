"
Performance:
Runtime: 10 ms, faster than 32.02% of Java online submissions for Bitwise AND of Numbers Range.
Memory Usage: 44.7 MB, less than 18.20% of Java online submissions for Bitwise AND of Numbers Range.
"

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int a = 0;
        while(left != right) {
        left >>= 1;
        right >>= 1;
        a++;
    }
    return left<<a; 
    }
}