class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();                          
        for (int i = 0; i < nums.length;) {                                      
            int temp = nums[i];
            if (temp != nums[temp - 1]) {
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {                               
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;                                                  
    }
}