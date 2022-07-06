"
Performance:
Runtime: 3 ms, faster than 94.44% of Java online submissions for Monotone Increasing Digits.
Memory Usage: 41.1 MB, less than 55.93% of Java online submissions for Monotone Increasing Digits.
"

class Solution {
    public int monotoneIncreasingDigits(int N) {
        List<Integer> list = new ArrayList<Integer>();
        while (N != 0 ) {
            list.add(0, N % 10);
            N /= 10;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1) ) {
                for (int j = i; j >= 0; j--) {
                    if (j == 0 || list.get(j) > list.get(j - 1)) {
                        list.set(j, list.get(j) - 1);
                        for (int k = j + 1; k < list.size(); k++) {
                            list.set(k, 9);
                        }
                        break;
                    }
                }
                break;
            }
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result * 10 + list.get(i);
        }
        return result;
    }
}