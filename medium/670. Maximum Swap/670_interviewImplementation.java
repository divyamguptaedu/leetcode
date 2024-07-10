class MaximumSwap {
    public int maximumSwap(int num) {
        int x = num;
        int delta = 0;
        int hi = x % 10;
        int multiple = 1;
        int prev = 1;
        x /= 10;

        while (x > 0) {
            multiple *= 10;
            int currentDigit = x % 10;

            if (currentDigit > hi) {
                hi = currentDigit;
                prev = multiple;
            } else if (currentDigit < hi) {
                delta = (hi - currentDigit) * multiple - (hi - currentDigit) * prev;
            }
            x /= 10;
        }

        return num + delta;
    }

    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();

        // Example usage
        int num = 2736;
        int result = solution.maximumSwap(num);
        System.out.println("Maximum valued number after at most one swap: " + result);
    }
}
