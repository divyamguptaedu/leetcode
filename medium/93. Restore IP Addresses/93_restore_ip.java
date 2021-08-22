"
Performance:
Runtime: 7 ms, faster than 32.59% of Java online submissions for Restore IP Addresses.
Memory Usage: 38.9 MB, less than 83.37% of Java online submissions for Restore IP Addresses.
"

class Solution {
	public List<String> restoreIpAddresses(String string) {
	    List<String> result = new LinkedList<>();
	    int[] path = new int[4];
	    helper(result, string, 0,  path, 0);
	    return result;
	}

	private void helper(List<String> account, String string, int index, int[] path,  int segment){
	    if (segment == 4 && index == string.length()) {
	        account.add(path[0] + "." + path[1] + "."+ path[2] + "." + path[3]);
	        return;
	    } else if (segment == 4 || index == string.length()) {
	        return ;
	    }
	    
	    for (int length = 1; length <= 3 && index + length <= string.length() ; length++) {
	        int val = Integer.parseInt(string.substring(index, index + length));
	        // range check, no leading 0.
	        if (val > 255 || length >= 2  && string.charAt(index) == '0') {
	            break; 
	        }
	            
	        path[segment] = val;
	        helper(account, string, index + length, path, segment + 1);
	        path[segment] = -1; // for debug. 
	    }
	}
}