//I traversed the logs one by one, keeping track of function execution using a stack. 
//For each log entry, I parsed the function ID and timestamp. 
//When encountering a start log, I updated the exclusive time of the current function by 
//subtracting the previous timestamp from the current one and added it to the function's time. 
//For end logs, I updated the exclusive time similarly but added 1 to account for inclusive time. 
//Finally, I returned the exclusive times for all functions.

//Time: O(n)
//Space: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int prevTime = 0; // Previous timestamp
        for (String log : logs) {
            String[] logarr = log.split(":");
            int id = Integer.parseInt(logarr[0]);
            int time = Integer.parseInt(logarr[2]);

            if (logarr[1].equals("start")) { // Start of function
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += time - prevTime; // Update exclusive time
                }
                stack.push(id); // Push function ID onto the stack
                prevTime = time; // Update previous timestamp
            } else { // End of function
                int topind = stack.pop(); // Pop function ID from stack
                ans[topind] += time - prevTime + 1; // Update exclusive time (add 1 for inclusive time)
                prevTime = time + 1; // Update previous timestamp
            }
        }
        return ans; // Return exclusive times for all functions
    }
}
