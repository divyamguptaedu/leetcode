//We add all the nums from the input list to a set, and then iterate over it. While iterating, we check if the currentNum is the start of a seqeunce.
//If yes, then we check the length of this sequence and save the max length seen till now.
//If no, we move to next number.
//Time: O(n)
//Space: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                result = Math.max(result, currentLength);
            }
        }

        return result;
    }
}