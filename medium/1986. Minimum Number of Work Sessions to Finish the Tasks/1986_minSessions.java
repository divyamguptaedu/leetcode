class Solution {
    int minBucket = Integer.MAX_VALUE;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        reverseHelper(tasks);
        backtrack(tasks, sessionTime, 0, new ArrayList<Integer>());
        return minBucket;
    }

    private void backtrack(int[] tasks, int sessionTime, int index, List<Integer> buckets) {
        if (buckets.size() >= minBucket) {
            return;
        }
        if (index == tasks.length) {
            minBucket = Math.min(minBucket, buckets.size());
            return;
        }
    
        buckets.add(tasks[index]);
        backtrack(tasks, sessionTime, index + 1, buckets);
        buckets.remove(buckets.size() - 1);

        for (int i = 0; i < buckets.size(); i++) {
            if (tasks[index] + buckets.get(i) <= sessionTime) {
                buckets.set(i, buckets.get(i) + tasks[index]);
                backtrack(tasks, sessionTime, index + 1, buckets);
                buckets.set(i, buckets.get(i) - tasks[index]);
            }
        }
    }

    private void reverseHelper(int[] tasks) {
        int i = 0;
        int j = tasks.length - 1;
        while (i < j) {
            int hold = tasks[i];
            tasks[i] = tasks[j];
            tasks[j] = hold;
            i++;
            j--;
        }
    }

}