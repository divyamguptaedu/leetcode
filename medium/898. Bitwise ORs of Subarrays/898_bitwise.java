"
Performance:
Runtime: 706 ms, faster than 9.57% of Java online submissions for Bitwise ORs of Subarrays.
Memory Usage: 231.2 MB, less than 9.84% of Java online submissions for Bitwise ORs of Subarrays.
"

class Solution {
	public int subarrayBitwiseORs(int[] arr) {
	    HashSet<Integer> result = new HashSet<>();
	    HashSet<Integer> previous = new HashSet<>();
	        
	    for (int num : arr) {
	        HashSet<Integer> temp = new HashSet<>();
	        temp.add(num);
	        for (int previousNumber: previous) {
	            temp.add(num | previousNumber);
	        }
	        previous = temp;
	        result.addAll(temp);
	    }
	        
	        return result.size();
	    }
	}
}