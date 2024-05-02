//To solve this question, we can use two heaps, maxHeap for smaller half of numbers, minHeap for larger half of the numbers.
//We can also create a hashtable to track invalid numbers, numbers which are invalid but still in the heap. This is done to avoid removing elements unnecessarily.
//To account for the difference between the way median is calculated for odd and even number of elements, 
//we will allow maxHeap to store one more element than the minHeap.
//So when the heaps are balanced, we can just take the topmost element and use it to calculate the mean.
//For odd numbers, we just use the top element of the maxheap
//For even numbers, we use top elements of both heaps and take a mean of those.
//Once the invalid element reaches the top of any of the heaps, thats when we remove it.

//Time: O(nlogk): n insertions into heap which takes logk each.
//Space: O(n): Heaps need k space, hash table needs n-k space. So, total becomes n.
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

        int i = 0; // index of current incoming element being processed

        // initialize the heaps
        while (i < k)
            lo.add(nums[i++]);
        for (int j = 0; j < k / 2; j++) {
            hi.add(lo.poll());
        }

        while (true) {
            // get median of current window
            medians.add(k % 2 != 0 ? (double) lo.peek() : ((double) lo.peek() + (double) hi.peek()) * 0.5);

            if (i >= nums.length)
                break; // break if all elements processed

            int outNum = nums[i - k], // outgoing element
                    inNum = nums[i++], // incoming element
                    balance = 0; // balance factor

            // number `outNum` exits window
            balance += (outNum <= lo.peek() ? -1 : 1);
            hashTable.put(outNum, hashTable.getOrDefault(outNum, 0) + 1);

            // number `inNum` enters window
            if (!lo.isEmpty() && inNum <= lo.peek()) {
                balance++;
                lo.add(inNum);
            } else {
                balance--;
                hi.add(inNum);
            }

            // re-balance heaps
            if (balance < 0) { // `lo` needs more valid elements
                lo.add(hi.poll());
                balance++;
            }
            if (balance > 0) { // `hi` needs more valid elements
                hi.add(lo.poll());
                balance--;
            }

            // remove invalid numbers that should be discarded from heap tops
            while (hashTable.containsKey(lo.peek()) && hashTable.get(lo.peek()) > 0) {
                hashTable.put(lo.peek(), hashTable.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && hashTable.containsKey(hi.peek()) && hashTable.get(hi.peek()) > 0) {
                hashTable.put(hi.peek(), hashTable.get(hi.peek()) - 1);
                hi.poll();
            }
        }

        double[] result = new double[medians.size()];
        for (int j = 0; j < medians.size(); j++) {
            result[j] = medians.get(j);
        }
        return result;
    }
}