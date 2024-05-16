class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        // maps number to frequency
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        int res = 1;
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            int key = entry.getKey();
            // checks if value starts chain of k difference values
            if (!numToFreq.containsKey(key - k)) {
                // speed up for lone values
                if (!numToFreq.containsKey(key + k)) {
                    res *= (1 << numToFreq.get(key));
                    continue;
                }
                // list of k difference values frequencies
                List<Integer> kDiff = new ArrayList<>();
                kDiff.add(numToFreq.get(key));
                // adds freqs to list in ascending order
                while (numToFreq.containsKey(key + k)) {
                    key += k;
                    kDiff.add(numToFreq.get(key));
                }
                int subsetWithout = 0, subsetWith = 0;
                // dynamic programming
                for (int freq : kDiff) {
                    // subsets from 0..i-2
                    subsetWithout = subsetWith + subsetWithout;
                    // subsets of current value * (subsets 0..i-2 + subset of self)
                    subsetWith = ((1 << freq) - 1) * ((subsetWithout - subsetWith) + 1);
                }
                // plus one to add empty subset
                res *= (subsetWith + subsetWithout + 1);
            }
        }
        // remove set of empty values
        return res - 1;
    }
}