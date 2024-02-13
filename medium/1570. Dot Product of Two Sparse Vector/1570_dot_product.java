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

//another solution

class SparseVector {

    List<Pair<Integer, Integer>> data = new ArrayList<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            data.add(new Pair(i, nums[i]));
        }
    }
    
    public int dotProduct(SparseVector vec) {
        if (data.size() < vec.data.size()) {
            return helper(this.data, vec.data);
        } else {
            return helper(vec.data, this.data);
        }
    }

    public int helper(List<Pair<Integer, Integer>> sparse, List<Pair<Integer, Integer>> notSparse) {
        int result = 0;
        for (Pair<Integer, Integer> pair : sparse) {
            int x = search(notSparse, pair.getKey());
            if (x != -1) {
                result += pair.getValue() * x;
            }
        }
        return result;
    }

    public int search(List<Pair<Integer, Integer>> data, int i) {
        int left = 0;
        int right = data.size() -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid).getKey() == i) {
                return data.get(mid).getValue();
            } else if (data.get(mid).getKey() < i) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);