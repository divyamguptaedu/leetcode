class DifferentSolution {
    public int calculateMinimumSeconds(List<Integer> nums) {
        int totalSize = nums.size();
        if (totalSize == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> dictionary = new HashMap<>();
        for (int j = 0; j < totalSize; j++) {
            int number = nums.get(j);
            if (!dictionary.containsKey(number)) {
                dictionary.put(number, new ArrayList<>());
            }
            dictionary.get(number).add(j);
        }
        int minimumTime = totalSize;
        for (List<Integer> valueList : dictionary.values()) {
            int maxDifference = (totalSize - valueList.get(valueList.size()-1) + valueList.get(0)) / 2;
            for (int k = 1; k < valueList.size(); k++) {
                int difference = valueList.get(k) - valueList.get(k - 1);
                maxDifference = Math.max(maxDifference, difference / 2);
            }
            minimumTime = Math.min(minimumTime, maxDifference);
        }
        return minimumTime;
    }
}
