class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int prevTime = 0;
        int last = 0;
        for (String log : logs) {
            String[] logarr = log.split(":");
            int id = Integer.parseInt(logarr[0]);
            int time = Integer.parseInt(logarr[2]);

            if (logarr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                int topind = stack.pop();
                ans[topind] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return ans;
    }
}