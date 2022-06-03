/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake Sorting.
Memory Usage: 42.3 MB, less than 89.85% of Java online submissions for Pancake Sorting.
*/


class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int size = A.length;
        while (size > 0){
            int index = helper(A , size);
            reverse(A , 0 , index);
            result.add(index + 1);
            reverse(A , 0 , size - 1);
            result.add(size);
            size--;
        }
        return result;
    }
    
    
    private void reverse(int [] nums, int leftInput, int rightInput){
        int left = leftInput;
        int right = rightInput;
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    private int helper(int [] nums, int target){
        int index = -1;
        for (int i = 0; i < nums.length; i++){ 
            if (nums[i] == target){
                index = i;
                break;
            }
        }
        return index;
    }
}