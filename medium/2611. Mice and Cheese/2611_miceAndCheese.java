//To solve this question, we can use a max heap pq. So, first we can check if k == #cheese. If yes, we just take the sum of the reward1 array and return.
//If not, we first take the sum of the reward2 array, then initialize the pq max heap, and add the difference of the reward1[i] and reward2[i] to the maxheap.
//Then we return the top k elements from the heap, and add the difference to the total.

//Time: O(NlogN)
//Space: O(N)
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = 0;
       
        if (k == reward1.length) { //because k is the limit for mouse 1.
            res = Arrays.stream(reward1).sum();
            return res;
        }
        int total = Arrays.stream(reward2).sum();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); //max heap
        for (int i = 0; i < reward1.length; i++) { //if reward for mouse 1 is higher, then add a +ve value to the heap
            int curr = reward1[i] - reward2[i]; //get the difference to be added to the total
            heap.add(curr);
        }
        for (int i = 0; i < k; i++) {
            total += heap.poll();
        }
        return total;
    }
}