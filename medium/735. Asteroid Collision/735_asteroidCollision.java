class Solution {
    public int[] asteroidCollision(int[] arr) {
        int[] stack = new int[arr.length];
        int top = -1;
        for (int temp : arr) {
            if (temp > 0) {
                stack[top++] = temp;
            } else {
                while (top != -1 && stack[top] > 0 && stack[top] + temp < 0) {
                    top--;
                }
                if (top == -1 || stack[top] < 0) {
                    stack[top++] = temp;
                } else if (stack[top] + temp == 0) {
                    top--;
                }
            }
        }

        int[] result = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            result[i] = stack[i];
        }
        return result;
    }
}