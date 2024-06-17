//I calculated the wage-to-quality ratio for each worker and sorted them based on this ratio. 
//Using a priority queue, I tracked the k workers with the lowest total quality. 
//For each worker, I added their quality to the priority queue and maintained the sum of qualities. 
//If the number of workers exceeded k, I removed the worker with the highest quality to minimize costs. 
//For exactly k workers, I computed the cost by multiplying the current total quality by the 
//current worker's ratio and updated the minimum cost accordingly.

//Time: nlogn + nlogk where n is the num of workers, k is size of pq.
//Space: n+k
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();

        // Calculate wage-to-quality ratio for each worker
        for (int i = 0; i < n; i++) {
            wageToQualityRatio.add(new Pair<>((double) wage[i] / quality[i], quality[i]));
        }

        // Sort workers based on their wage-to-quality ratio
        Collections.sort(wageToQualityRatio, new Comparator<Pair<Double, Integer>>() {
            @Override
            public int compare(Pair<Double, Integer> p1, Pair<Double, Integer> p2) {
                return Double.compare(p1.getKey(), p2.getKey());
            }
        });


        // Use a priority queue to keep track of the highest quality workers
        PriorityQueue<Integer> workers = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through workers
        for (int i = 0; i < n; i++) {
            workers.add(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();

            // If we have more than k workers,
            // remove the one with the highest quality
            if (workers.size() > k) {
                currentTotalQuality -= workers.poll();
            }

            // If we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (workers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * wageToQualityRatio.get(i).getKey());
            }
        }
        return totalCost;
    }
}