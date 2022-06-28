"""
Performance:
Runtime: 23 ms, faster than 43.85% of Java online submissions for Exclusive Time of Functions.
Memory Usage: 53 MB, less than 14.90% of Java online submissions for Exclusive Time of Functions.
"""

class Solution {
    private class FunctionCall {
        int id;
        boolean start;
        int time;
        int tempTime;
        FunctionCall(String str) {
            String[] split = str.split(":");
            this.id = Integer.parseInt(split[0]);
            this.start = split[1].equals("start");
            this.time = Integer.parseInt(split[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<FunctionCall> stack = new Stack<>();
        int[] result = new int[n];
        for (String log: logs) {
            FunctionCall present = new FunctionCall(log);
            if (present.start) {
                stack.push(present);
            } else {
                FunctionCall pop = stack.pop();
                int current = present.time - pop.time + 1;
                result[pop.id] += current - pop.tempTime;

                if (!stack.isEmpty()) {
                    stack.peek().tempTime += current;
                }
            }
        }
        return result;
    }
}