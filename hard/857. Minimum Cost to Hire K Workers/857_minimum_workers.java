"
Performance:
Runtime: 26 ms, faster than 47.58% of Java online submissions for Minimum Cost to Hire K Workers.
Memory Usage: 40.5 MB, less than 54.76% of Java online submissions for Minimum Cost to Hire K Workers.
"

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double workers[][] = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare (a[0], b[0]));
        Double sum = 0.0;
        Double minimum = Double.MAX_VALUE;
        PriorityQueue<Double> queue = new PriorityQueue<>();
        for (double[] worker: workers){
            sum += worker[1];
            queue.add(-worker[1]);
            if (queue.size() > K){
                sum += queue.poll();
            }
            if (queue.size() == K){
                minimum = Math.min(minimum, sum * worker[0]);
            }
        }
        return minimum;
    }
}