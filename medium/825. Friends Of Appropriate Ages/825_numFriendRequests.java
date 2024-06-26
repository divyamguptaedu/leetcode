//To solve this question, we first sort the array to be able to use binary search. For every age in the array, we first find the 
//minimum age the person will become friends with i.e. age[i]/2 + 7. Then if the min age < age[i], we find the index of the first element
//greater or eq than the minAge using binary Search. Then we find the index of the last element equal to age[i] because there can be multiple 
//people of the same age. Once we have the left and right index, the user i can send a friend request to every user in this range except itself.
//So, we can update the request count.

//Time: O(nlogn)
//Space: O(logn) quicksort takes logn space.
class Solution {
    public int numFriendRequests(int[] ages) {
        int requestCount = 0;
        // sort the array to enable binary search
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            // exclusive minimum age based on the provided formula
            int minAge = ages[i] / 2 + 7;
            if (minAge < ages[i]) {
                // find the index of the first element greater than minAge
                int leftIdx = binarySearch(ages, 0, ages.length, minAge);
                // find the index of the last element equal to ages[i] - there
                // is at least 1 such element (ages[i]) but there may be more
                int rightIdx = binarySearch(ages, 0, ages.length, ages[i]) - 1;
                // user i can send a friend request to every user in the
                // [leftIdx, rightIdx] range except itself - the number of
                // users in the range is calculated as rightIdx - leftIdx + 1,
                // but we subtract 1 to exclude user i
                requestCount += rightIdx - leftIdx;
            }
        }
        return requestCount;
    }

    // binary search to find the first age value that is greater than the
    // provided target in O(log n) time
    private int binarySearch(int[] ages, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (ages[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // l is the index of the smallest age value for which the condition
        // ages[mid] > target evaluates as true
        return l;
    }
}