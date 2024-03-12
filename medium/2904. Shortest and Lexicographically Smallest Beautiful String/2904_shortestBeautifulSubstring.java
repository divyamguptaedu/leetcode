class Solution {
    public String shortestBeautifulSubstring(String inputString, int requiredCount) {
        List<String> resultSet = new ArrayList<>();
        int minLength = inputString.length();
        int slowPointer = 0, fastPointer = 0, currentCount = 0;
        
        while (fastPointer < inputString.length()) {
            if (inputString.charAt(fastPointer) == '1') {
                currentCount++;
            }

            while (currentCount == requiredCount) {
                if (minLength > fastPointer - slowPointer + 1) {
                    resultSet = new ArrayList<>();
                    minLength = fastPointer - slowPointer + 1;
                } 
                if (fastPointer - slowPointer + 1 == minLength) {
                    resultSet.add(inputString.substring(slowPointer, fastPointer + 1));
                }
                if (inputString.charAt(slowPointer) == '1') {
                    currentCount--;
                }
                slowPointer++;
            }

            fastPointer++;
        }
    
        if (resultSet.size() == 0) {
            return "";
        }
        Collections.sort(resultSet);
        return resultSet.get(0);
    }
}
