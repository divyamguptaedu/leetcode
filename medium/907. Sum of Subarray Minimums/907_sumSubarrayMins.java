class Solution {
    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        long mod = (long) 1000000007;
        stack.push(-1);
        for (int i = 0; i < arr.length+1; i++) {
            int currVal = (i <= arr.length - 1) ? arr[i] : 0;
            while (stack.peek() !=-1 && currVal < arr[stack.peek()]) {
                int index = stack.pop();
                int j = stack.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long) arr[index]) % mod;
                result += add ;
                result %= mod;
            }
            stack.push(i);
        }
        return result;
    }
}