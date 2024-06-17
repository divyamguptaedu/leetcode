//To find all elements in an array that appear more than ⌊ n/3 ⌋ times, 
//I utilized a modified version of the Boyer-Moore Voting Algorithm. 
//In the first pass, I tracked two potential candidates and their counts. 
//If a number matches either candidate, I incremented its count; otherwise, 
//I decremented both counts. If a count drops to zero, I reassigned that candidate.
//In the second pass, I verified the counts of the candidates found in the first pass 
//to confirm their frequency meets the requirement. If so, I added them to the result list.

//Time: n
//Space: constant
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // 1st pass
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n : nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass to check if the candidates have count > n/3 and also form the result.
        List result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (candidate1 != null && n == candidate1)
                count1++;
            if (candidate2 != null && n == candidate2)
                count2++;
        }

        int n = nums.length;
        if (count1 > n / 3)
            result.add(candidate1);
        if (count2 > n / 3)
            result.add(candidate2);

        return result;
    }
}