class Solution {
    int ans;
    public int maxLength(List<String> arr) {
        HashSet<Character> setOne = new HashSet<Character>();
        ans = 0;
        helper(arr,  0, 0, setOne);
        return ans;
    }
    
    public void helper(List<String> arr, int position, int length, HashSet<Character> setOne){
    	if(position == arr.size()) {
    		if(ans < length)
    			ans = length;
    		return;
    	}
        helper(arr, position + 1, length, setOne);
        HashSet<Character> setTwo = new HashSet<>(setOne);
        for(int i = 0; i < arr.get(position).length(); i++){
            if(setTwo.contains(arr.get(position).charAt(i))){
                helper(arr, position + 1, length, setTwo);
                return;
            }
            setTwo.add(arr.get(position).charAt(i));
        }
        helper(arr, position + 1, length + arr.get(position).length(), setTwo);
    }
}