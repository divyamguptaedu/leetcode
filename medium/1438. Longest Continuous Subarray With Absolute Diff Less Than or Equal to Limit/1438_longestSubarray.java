//We can solve this question using a sliding woindow approach. We would need to keep track 
//of the min and max, so for that we can initialize two deques, incresing and decreasing.
//Increasing deque will give us the minimum, decreasing will give us the maximum at the front.
//We will keep on moving the right pointer, populating the deques and once the limit is reached, 
//we fix the min and max, and move the left pointer.

//Time: O(n)
//Space: O(n)
class Solution {
    public int longestSubarray(int[] arr, int l) {
        int i = 0; //left pointer
        int j = 0; //right pointer
        int result = 0;
        Deque<Integer> q1 = new ArrayDeque<>(); // incresingDeque
        Deque<Integer> q2 = new ArrayDeque<>(); // decreasingDeque

        for (; j < arr.length; j++) {
            // keep queue in asc order, keep the min
            while (!q1.isEmpty() && arr[q1.peekLast()] > arr[j]) {
                q1.pollLast();
            }
            q1.offerLast(j);

            // keep queue in des order, keep the max
            while (!q2.isEmpty() && arr[q2.peekLast()] < arr[j]) { 
                q2.pollLast();
            }
            q2.offerLast(j);

            while (arr[q2.peekFirst()] - arr[q1.peekFirst()] > l) { //if limit exceeded

                // move i to right to adjust the window when the condition is KO
                // if arr[i] is index of max or min value of queues, need to remove in queue
                // before move i

                if (q2.peekFirst() == i)
                    q2.pollFirst();
                if (q1.peekFirst() == i)
                    q1.pollFirst();

                i++;
            }

            result = Math.max(result, j - i + 1); //keep the max length
        }
        return result;
    }
}