class Solution {
    public int[] findIndices(int[] nums,int indexDifference,int valueDifference) {
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (true) {
            int x = Math.abs(i - j);
            int y = Math.abs(nums[i] - nums[j]);
            if (x >= indexDifference && y >= valueDifference) {
                result[0] = i;
                result[1] = j;
                break;
            }
            if (j < n - 1) {
                j++;
            }
            else if (i < j - 1) {
                i++;
                j = i + 1;
            }
            else {
                break;
            }
        }
        return result;
    }
}

