"""
Performance:
Runtime: 15 ms, faster than 34.28% of Java online submissions for Task Scheduler.
Memory Usage: 39.6 MB, less than 87.03% of Java online submissions for Task Scheduler.
"""

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
        	return tasks.length;
        }

        // create a hashmap with values of each unique task;
        HashMap<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
        	if (valueMap.get(tasks[i]) == null) {
        		valueMap.put(tasks[i], 1);
        	} else {
        		valueMap.put(tasks[i], valueMap.get(tasks[i]) + 1);
        	}
        }

        // add all values to the queue in a descending order;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : valueMap.values()) {
        	queue.add(x);
        }
        // get the tast with the maximum frequency;
        int maximum = queue.poll();
        int idleTime = (maximum - 1) * n;

        // compute idle time;
        while (!queue.isEmpty()) {
        	int current = queue.poll();
        	if (current == maximum) {
        		idleTime = idleTime + 1;
        	}
        	idleTime = idleTime - current;
        }

        int result;

        // return idleTime + tasks.length;
        if (idleTime > 0) {
        	result = idleTime + tasks.length;
        } else {
        	result = tasks.length;
        }

        return result;

    }
}