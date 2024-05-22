//I iterate through the input array of binary strings. 
//For each string, I access the character at the current index i and append its 
//complement to the result string. Since the input strings are of length n and 
//each string is unique, I can guarantee that there will be no repetition in the 
//resulting binary string. Thus, I obtain a binary string of length n that is 
//different from any string in the input array. 

//Time: O(n)
//Space: O(1)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }

        return ans.toString();
    }
}