class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            number.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }
        return number.toString();
    }
}