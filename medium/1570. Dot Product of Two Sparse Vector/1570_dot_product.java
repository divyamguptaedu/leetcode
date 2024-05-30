//I constructed a SparseVector class to efficiently compute the dot product between two sparse vectors. 
//In the constructor, I stored the non-zero values and their indices in a HashMap. 
//During the dotProduct method, 
//I iterated through each non-zero element in one sparse vector and checked if 
//the corresponding index had a non-zero value in the other vector. 
//If found, I added the product of their values to the result. 
//This approach reduces computational complexity by avoiding unnecessary calculations for zero values.

//Time: O(n) where n is length of nums
//Space: O(l) l is the number of non zero elements in the vector.
class SparseVector {
    // Map the index to value for all non-zero values in the vector
    Map<Integer, Integer> mapping;      

    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                mapping.put(i, nums[i]);        
            }
        }
    }

    public int dotProduct(SparseVector vec) {        
        int result = 0;

        // iterate through each non-zero element in this sparse vector
        // update the dot product if the corresponding index has a non-zero value in the other vector
        for (Integer i : this.mapping.keySet()) {
            if (vec.mapping.containsKey(i)) {
                result += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        return result;
    }
}