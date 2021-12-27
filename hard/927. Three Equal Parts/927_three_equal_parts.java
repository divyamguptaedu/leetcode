"
Performance:
Runtime: 2 ms, faster than 82.22% of Java online submissions for Three Equal Parts.
Memory Usage: 45.3 MB, less than 31.11% of Java online submissions for Three Equal Parts.
"

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int ones = 0;
        for (int i : arr) {
            if (i == 1) {
                ones++;
            }
        }
        if (ones == 0) {
            return new int[]{0, 2};
        }
		
        if (ones % 3 != 0) {
            return new int[]{-1, -1};
        }

        int onePoint = 0;
        int twoPoint = 0;
        int threePoint = 0;
        int unit = ones / 3;
        int oneNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (oneNumber == 0) {
                    onePoint = i;
                }
                else if (oneNumber == unit) {
                    twoPoint = i;
                }
                else if (oneNumber == 2 * unit) {
                    threePoint = i;
                }
                oneNumber++;
            }
        }

        while (threePoint < arr.length) {
            if (arr[onePoint] != arr[twoPoint] || arr[twoPoint] != arr[threePoint]) {
                return new int[]{-1, -1};
            }
            onePoint++;
            twoPoint++;
            threePoint++;
        }

        return new int[]{onePoint - 1, twoPoint};
    }
}