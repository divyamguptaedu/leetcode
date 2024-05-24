//I used backtracking to generate valid IP addresses from a string. 
//Starting from the first character, I iterated through the string and formed segments of one to three characters. 
//I checked if each segment was valid (not exceeding 255 and no leading zeros). 
//If valid, I appended the segment followed by a dot and recursively processed the remaining string. 
//When the depth reached three, I checked if the remaining string formed a valid segment, completed the IP address, 
//and added it to the result list. 
//I used a StringBuilder to efficiently manage the segments during recursion.

//Time: O(M^N * N) logic, but O(1) reality. where we are seperating the input string into N integers, and each integer is at most M digits. 
//Given that for this question m = 3, n = 4, the time complexity is 0(1) 
//Space: O(M*N) but for this question O(1)
class Solution {
    // List to store the valid IP addresses
    List<String> ansList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // Start the backtracking process
        solve(0, s, new StringBuilder(""));
        return ansList;
    }

    // Backtracking function to generate valid IP addresses
    void solve(int depth, String s, StringBuilder sb) {
        // Base case: If we've placed 3 dots, check the remaining string
        if (depth == 3) {
            if (isValid(s)) { // Check if the remaining segment is valid
                sb.append(s); // Append the final segment to the current IP address
                ansList.add(sb.toString()); // Add the complete IP address to the list
                sb.setLength(sb.length() - s.length()); // Remove the added segment for backtracking
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int i = 1; i <= 3; i++) {
            if (i >= s.length()) // Ensure there are enough characters left for the segment
                break;
            String temp = s.substring(0, i); // Extract the segment
            if (isValid(temp)) { // Check if the segment is valid
                sb.append(temp).append("."); // Append the segment and a dot
                solve(depth + 1, s.substring(i), sb); // Recursively process the remaining string
                sb.setLength(sb.length() - (temp.length() + 1)); // Remove the segment and dot for backtracking
            }
        }
    }

    // Helper function to check if a segment is a valid IP address component
    boolean isValid(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) // Check for length and leading zero
            return false;
        int val = Integer.valueOf(s); // Convert string to integer
        return val >= 0 && val <= 255; // Ensure the value is within the valid IP range
    }
}
