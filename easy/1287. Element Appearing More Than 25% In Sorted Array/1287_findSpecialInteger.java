//I identified potential candidates for the element that appears more than 25% by examining
//the elements at positions n/4, n/2, and 3n/4 in the sorted array. 
//For each candidate, I used binary search to find the range of its occurrences. 
//If the length of this range exceeded 25% of the array's length, I returned that candidate. 
//If no such candidate was found, I returned -1.

//Time: O(logn)
//Space: O(1)
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        // Identifying potential candidates
        int[] candidates = { arr[n / 4], arr[n / 2], arr[3 * n / 4] };
        int target = n / 4;

        for (int candidate : candidates) {
            // Finding the left boundary of the candidate
            int left = lower_bound(arr, candidate);
            // Finding the right boundary of the candidate
            int right = upper_bound(arr, candidate) - 1;
            // If the number of occurrences of candidate is more than 25% of the array length, return it
            if (right - left + 1 > target) {
                return candidate;
            }
        }
        // If no candidate found, return -1
        return -1;
    }

    // Binary search for the upper bound
    public int upper_bound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search for the lower bound
    public int lower_bound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}