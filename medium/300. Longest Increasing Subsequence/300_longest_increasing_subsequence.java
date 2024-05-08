//To solve this question, we can intelligently build the sequence. For each element in num, if num is greater than the largest element 
//in the subsequence, then we add it to the subsequence. Otherwise, we perform binary search on the subseq to replace the element that is >= num with num.
//This is done to have the longest subsequence. This algo may not always give the correct subseq, but we care about the length which will always be the longest.

//Time: O(nlogn): Iterating over the nums takes n time and doing binary search to find an element in the sub which is >= num takes logn time.
//Space: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}