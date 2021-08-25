"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Dot Product of Two Sparse Vectors.
Memory Usage: 53.9 MB, less than 50.96% of Java online submissions for Dot Product of Two Sparse Vectors.
"

class SparseVector {
    int[] vector;
    SparseVector(int[] nums) {
        this.vector = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] input = vec.vector;
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result += input[i] * this.vector[i];
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);