//I maintained variables for the previous product and its count to handle cases where consecutive products are the same. 
//If the current product differs from the previous one, I added the previous product to the result. 
//I continued this process until both arrays were fully traversed, 
//adding the last calculated product to the result. 
//Finally, I returned the compressed run-length encoded array.

//Time: O(n+m) where n and m are the lengths of the two input arrays
//Space: O(1)
class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        int prevProd = 0; // Previous product
        int prevCount = 0; // Previous count

        // Iterate through both run-length encoded arrays
        while (index1 < encoded1.length) {
            int prod = encoded1[index1][0] * encoded2[index2][0]; // Calculate the product
            int count = Math.min(encoded1[index1][1], encoded2[index2][1]); // Calculate the frequency

            // Check if the current product is the same as the previous one
            if (prevProd == 0) {
                prevProd = prod;
                prevCount = count;
            } else if (prevProd == prod) {
                prevCount += count;
            } else {
                // If the current product is different, add the previous product to the result
                result.add(List.of(prevProd, prevCount));
                prevProd = prod;
                prevCount = count;
            }

            // Update indices based on remaining frequencies
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

        // Add the last calculated product to the result
        result.add(List.of(prevProd, prevCount));

        return result;
    }
}