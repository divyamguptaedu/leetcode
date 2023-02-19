class Solution {
    private static final double temp = 1e-6;

    public boolean judgePoint24(int[] nums) {
        double[] A = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            A[i] = nums[i];
        }
        return backtrack(A, A.length);
    }

    private boolean backtrack(double[] A, int n) {
        if (n == 1) {
            return Math.abs(A[0] - 24) < temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = A[i], b = A[j];
                A[j] = A[n-1];
                A[i] = a + b;
                if (backtrack(A, n - 1)) {
                    return true;
                }
                A[i] = a - b;
                if (backtrack(A, n - 1)) {
                    return true;
                }
                A[i] = b - a;
                if (backtrack(A, n - 1)) {
                    return true;
                }
                A[i] = a * b;
                if (backtrack(A, n - 1)) {
                    return true;
                }
                if (Math.abs(b) > temp) {
                    A[i] = a / b;
                    if (backtrack(A, n - 1)) {
                        return true;
                    }
                }
                if (Math.abs(a) > xv) {
                    A[i] = b / a;
                    if(backtrack(A, n - 1)) {
                        return true;
                    }
                }
                A[i] = a; A[j] = b;
            }
        }
        return false;
    }
}