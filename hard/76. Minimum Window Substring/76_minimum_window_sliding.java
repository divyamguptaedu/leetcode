"""
Performance:
Runtime: 3 ms, faster than 96.20% of Java online submissions for Minimum Window Substring.
Memory Usage: 39.2 MB, less than 77.70% of Java online submissions for Minimum Window Substring
"""

class Solution {
	public String minWindow(String s, String t) {
	    if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
	    
	    int[] tmap = new int[256]; 
	    boolean[] tbmap = new boolean[256]; 
	    
	    for (int i = 0; i < t.length(); i++){
	        tmap[t.charAt(i)]++;
	        tbmap[t.charAt(i)] = true;
	    }
	    
	    int i = 0, j = 0; 
	    int found  = 0; 
	    int len = Integer.MAX_VALUE;
	    String res = "";
	    
	    while(j < s.length()){
	        char cj = s.charAt(j);
	        if(found < t.length()){ 
	            if(tbmap[cj]){
	                if(tmap[cj] > 0) {   
	                    found++;
	                }
	                tmap[cj]--;
	            }
	            j++;
	        }
	        
	        while(found == t.length()){ 
	            char ci = s.charAt(i);
	            if(!tbmap[ci]) i++;
	            else if (tmap[ci] < 0){ 
	                tmap[ci]++;
	                i++;
	            }else{
	                if(j-i < len){
	                    res = s.substring(i, j);
	                    len = j - i;
	                }
	                found--;
	                tmap[ci]++;
	                i++;
	            }
	        }
	        
	    }
	    
	    return res;
	}
}