class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        int prevProd = 0;
        int prevCount = 0;

        while (index1 < encoded1.length) {
            int prod = encoded1[index1][0] * encoded2[index2][0];
            int count = Math.min(encoded1[index1][1], encoded2[index2][1]);

            // Mainting prevProd so that cases where previous product
            // was same doesn't get added as separate element
            if (prevProd == 0) {
                prevProd = prod;
                prevCount = count;
            } else if (prevProd == prod) {
                prevCount += count;
            } else {
                // If current product is different than previous product,
                // add previous product to result
                result.add(List.of(prevProd, prevCount));
                prevProd = prod;
                prevCount = count;
            }

            if (encoded1[index1][1] == encoded2[index2][1]) {
                index1++;
                index2++;
            } else if (encoded1[index1][1] > encoded2[index2][1]) {
                encoded1[index1][1] -= encoded2[index2][1];
                index2++;
            } else {
                encoded2[index2][1] -= encoded1[index1][1];
                index1++;
            }
        }

        // Adds last calculated product to result
        result.add(List.of(prevProd, prevCount));

        return result;
    }
}