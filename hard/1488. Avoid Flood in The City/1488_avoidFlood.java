class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> fullMap = new HashMap();
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        List<Integer> dryDays = new ArrayList();

        for (int i = 0; i < n; i++) {
            int lakeIndex = rains[i];
            if (lakeIndex == 0) {
                dryDays.add(i);
                continue;
            }
            if (fullMap.containsKey(lakeIndex)) {
                int rainDay = fullMap.get(lakeIndex);
                int earliestDryDay = getNearestDryDay(dryDays, rainDay);
                if (earliestDryDay == -1) {
                    return new int[]{};
                }
                result[earliestDryDay] = lakeIndex;
            }
            fullMap.put(lakeIndex, i);
            result[i] = -1;
        }
        return result;
    }

    private int getNearestDryDay(List<Integer> dryDays, int rainDay) {
        int low = 0;
        int high = dryDays.size() - 1;
        int index = -1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = dryDays.get(mid);
            if (current > rainDay) {
                index = mid;
                answer = current;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (index != -1) {
            dryDays.remove(index);
        }
        return answer;
    }
}