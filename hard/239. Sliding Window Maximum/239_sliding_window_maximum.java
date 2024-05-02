//We can solve it the bruteforce way but the time complexity would not be linear. 
//We can avoid the repeated work by using a deque in a way that it stores numbers in a decreasing order.
//So, we create the dq, result list, start by iterating over the first k elements, save the max till now in the deque
//Remove smaller numbers from the deque and keep the largest in the end and then add the max to the result.
//Then we start moving the window, chop off the left most, check if it was the max, remove it if yes.
//Then again, populate the deque, remove smallers ones, add the max to the result.

//Time: O(n) where n is the length of nums, each element can be added to the deque once and removed once.
//Space: O(k) //size of the deque can be k max
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) { //setup the first window
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) { //populate the deque from the end
                dq.pollLast(); //remove smaller numbers
            }
            dq.offerLast(i); //add the max
        }
        res.add(nums[dq.peekFirst()]); //add the max of this window to result

        for (int i = k; i < nums.length; i++) { //move the window to the right
            if (dq.peekFirst() == i - k) { //if the element choppped off from the lest the max?
                dq.pollFirst(); //remove it
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) { //populate the deque from the end
                dq.pollLast(); //remove smaller numbers
            }

            dq.offerLast(i); //add the max
            res.add(nums[dq.peekFirst()]); //add the max of this window to result
        }
        // Return the result as an array.
        return res.stream().mapToInt(i->i).toArray(); //convert to array and return
    }
}