//I used a stack to keep track of elements in nums2 for which we are looking for the next 
//greater element. I iterated through nums2, and for each element, 
//I checked if it was greater than the element on top of the stack. 
//If it was, I popped the stack and mapped the popped element to the current element 
//in a hash map. After processing nums2, I assigned -1 as the next greater element 
//for any remaining elements in the stack. Finally, I created the result array for 
//nums1 by looking up each element in the hash map.

//Time: n where n is the num of elements in nums2
//Space: n
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}