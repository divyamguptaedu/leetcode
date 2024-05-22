//In this algorithm, I iterated through the binary strings a and b from right to left, 
//simulating binary addition. I ensured that a is longer than b for simplicity. 
//Using a carry variable, I added the corresponding bits of a and b, along with any 
//carry from the previous addition. The result of each addition modulo 2 gives the current bit,
//which I appended to the result. If there was a carry after the last bit addition, 
//I appended it as well. Finally, I reversed the result string to obtain the 
//binary sum of a and b.

//Time: O(max(n, m)) where n and m are the length of a and b
//Space: O(max(n, m))
class Solution {
    public String addBinary(String a, String b) { //expect a.length > b.length
        int n = a.length();
        int m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = m - 1;
        for (int i = n - 1; i > -1; --i) {
            if (a.charAt(i) == '1') {
                ++carry;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                ++carry;
            }

            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }

            carry /= 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }
}