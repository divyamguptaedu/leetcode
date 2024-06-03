//I iterated through the tasks array, maintaining a hashmap to track the last occurrence 
//of each task type. If the space between the last occurrence and the current index is 
//less than the specified space, I updated the current day to the last occurrence plus 
//the space plus one. Finally, I returned the current day, representing the minimum number 
//of days needed to complete all tasks. 

//Time: O(n)
//Space: O(n)
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        long x = 0; // Current day
        Long y = 0L; // Last occurrence of task
        HashMap<Integer, Long> map = new HashMap<>(); // Map to store task occurrences
        for (int i : tasks) {
            y = map.get(i);
            // If the space between the last occurrence and the current index is less than the specified space
            if (y != null && !(x - y - 1 >= space)) {
                x = y + space + 1; // Update the current day
            }
            map.put(i, x++); // Update the last occurrence of the task in the map
        }
        return x; // Return the current day
    }
}
