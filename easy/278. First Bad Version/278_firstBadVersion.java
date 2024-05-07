//To solve this question, we can use an easy binary search solution.
//Left would be 1, right would be n, while left < right, we find the mid and check if it is badversion.
//If yes, we set right to mid, not mid - 1 because we still don't know if mid is the first badversion or not.
//If not, we set the left = mid + 1.
//In the end, we return left.

//Time: O(log n)
//Space: O(1)

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right ) / 2;
            if (isBadVersion(mid)) {
                right = mid; //mid may be the first bad version or not, cannot discard
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}