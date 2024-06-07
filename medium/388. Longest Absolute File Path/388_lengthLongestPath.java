//I split the input string by newline characters to process each path component individually.
//For each component, I determined its depth based on the number of leading
//tab characters. I used a list to keep track of the length of each directory at
//each level. When I encountered a file (identified by the presence of a dot),
//I calculated the total length of the path to that file and updated the maximum
//length if this path was the longest found so far.

//Time: n
//Space: n
class Solution {
    public int lengthLongestPath(String input) {
        int maxLength = 0; // Initialize the maximum length of the path
        List<Integer> pathLengths = new ArrayList<>(); // List to store lengths of directories/files at each level
        String[] paths = input.split("\n"); // Split input string into individual paths
        
        for (String path : paths) {
            if (path.isEmpty()) {
                continue; // Skip empty paths
            }
            
            int level = 0;
            while (path.charAt(level) == '\t') {
                level++; // Count the number of leading tabs to determine the depth
            }
            
            String cleanPath = path.substring(level); // Remove the leading tabs
            if (pathLengths.size() <= level) {
                pathLengths.add(cleanPath.length()); // Add new level length
            } else {
                pathLengths.set(level, cleanPath.length()); // Update existing level length
            }
            
            if (cleanPath.contains(".")) { // Check if it's a file
                int totalLength = 0;
                for (int i = 0; i <= level; i++) {
                    totalLength += pathLengths.get(i); // Sum up the lengths from root to this file
                }
                totalLength += level; // Add the slashes between directories/files
                maxLength = Math.max(maxLength, totalLength); // Update max length if necessary
            }
        }
        
        return maxLength; // Return the maximum length of the path found
    }
}