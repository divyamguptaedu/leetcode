//Initially, I sorted all projects by their capital in ascending order.
//Using a max heap (implemented with PriorityQueue and Collections.reverseOrder()) for chosing the project with max capital.
//I dynamically tracked and selected up to k projects that I could afford with my current capital w. 
//For each eligible project, its profit was added to w, and this process continued until either k projects were selected or 
//no more projects could be chosen due to insufficient capital. 
//Finally, w represents the maximum capital achievable after selecting the optimal set of projects.
//Time: nlogn
//Space: n
class Solution {
    class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        // PriorityQueue is a min heap, but we need a max heap, so we use
        // Collections.reverseOrder()
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < n && projects[ptr].capital <= w) {
                q.add(projects[ptr++].profit);
            }
            if (q.isEmpty()) {
                break;
            }
            w += q.poll();
        }
        return w;
    }
}