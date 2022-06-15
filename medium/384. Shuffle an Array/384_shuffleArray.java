"
Performance:
Runtime: 107 ms, faster than 71.57% of Java online submissions for Shuffle an Array.
Memory Usage: 68.1 MB, less than 14.35% of Java online submissions for Shuffle an Array.
"

class Solution {
    int[] array;
    Random random;
    public Solution (int[] nums) {
        array = nums;
        random = new Random();
    }

    public int[] reset() {
        return array;
    }

    public int[] shuffle() {
        int[] temp = array.clone();
        int size = temp.length;
        while (size > 0) {
            int index = random.nextInt(size);
            int tempTwo = temp[index];
            temp[index] = temp[size - 1];
            temp[size - 1] = tempTwo;
            size--;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */