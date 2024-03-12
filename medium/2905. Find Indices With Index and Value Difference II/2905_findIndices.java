class Solution {
    public int[] findIndices(int[] numbers, int indexDif, int valueDif) {
        int[] result = new int[]{-1, -1};

        List<int[]> resultList = new ArrayList<>();
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            }
            resultList.add(new int[]{minIndex, maxIndex});
        }

        for (int i = 0; i < numbers.length; i++) {
            int j = i - indexDif;
            if (j >= 0) {
                if (Math.abs(numbers[i] - numbers[resultList.get(j)[0]]) >= valueDif) {
                    return new int[]{resultList.get(j)[0], i};
                }
                if (Math.abs(numbers[i] - numbers[resultList.get(j)[1]]) >= valueDif) {
                    return new int[]{resultList.get(j)[1], i};
                }
            }

        }

        return new int[]{-1, -1};
    }
}
