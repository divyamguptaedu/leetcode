"
Performance:
Runtime: 1468 ms, faster than 95.03% of Java online submissions for Most Profit Assigning Work.
Memory Usage: 62.6 MB, less than 42.69% of Java online submissions for Most Profit Assigning Work.
"

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int total = 0;
        int maximum = 0;
        int result = 0;
        List<int[]> list = new LinkedList<>();
        for (int j = 0; j < profit.length; j++) {
            list.add(new int[]{difficulty[j], profit[j]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        Arrays.sort(worker);
        int index = 0;
        for (int ability : worker) {
            while (index < profit.length && ability >= list.get(index)[0]) {
                maximum = Math.max(maximum, list.get(index++)[1]);
            }
            result += maximum;
        }
        return result;
    }
}