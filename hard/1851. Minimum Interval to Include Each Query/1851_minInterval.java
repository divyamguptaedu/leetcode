class Solution {

    public class Interval {

        int left;
        int right;
        int len;

        public Interval(int[] interval) {
            this.left = interval[0];
            this.right = interval[1];
            this.len = right - left + 1;
        }
    }
    
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] queriesClone = queries.clone();
        Arrays.sort(queriesClone);

        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>( (a,b) -> a.len - b.len );

        int index = 0;

        for (int query : queriesClone) {

            while(index < intervals.length && intervals[index][0] <= query) {
                pq.offer(new Interval(intervals[index]));
                index++;
            }
            
            while(!pq.isEmpty() && pq.peek().right < query) {
                pq.poll();
            }

            if(!pq.isEmpty()) {
                hm.put(query, pq.peek().len);
            }
        }
        
        int[] res = new int[queries.length];

        int i=0;
        for (int query : queries) {
            res[i++] = hm.getOrDefault(query, -1);
        }

        return res;
    }
}