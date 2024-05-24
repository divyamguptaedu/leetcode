//I utilized a breadth-first search (BFS) approach to solve this problem. 
//First, I sorted the target string and stickers to normalize them for comparison. 
//Then, I used BFS to find the minimum number of stickers needed. 
//At each step, I matched the target with each sticker, filtering out the remaining letters. 
//If a sticker covers all letters in the target, I return the step count. 
//Otherwise, I continue BFS until all possibilities are exhausted.

//Time: O(MNlogM) where M is the length of the stickers array, N is the length of target string.
//Sorting the stickers take MlogM time, filtering each sticker against the target takes NM time.
//Space: O(NM)
class Solution {
    // Main function to find the minimum number of stickers needed to form the target
    public int minStickers(String[] stickers, String target) {
        // Sort the target and stickers for comparison
        String sortedTarget = sortString(target);
        String[] sortedStickers = new String[stickers.length];
        for (int i = 0; i < sortedStickers.length; i++) {
            sortedStickers[i] = sortString(stickers[i]);
        }

        // BFS to find minimum number of stickers needed
        Queue<String> queue = new LinkedList<>();
        int steps = 1;
        Set<String> visited = new HashSet<>();
        queue.offer(sortedTarget);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentStr = queue.poll();
                // Match with each sticker and filter the target
                for (int j = 0; j < sortedStickers.length; j++) {
                    String remStr = filterByMatching(sortedStickers[j], currentStr);
                    if (remStr.isEmpty()) {
                        return steps;
                    }
                    if (!visited.contains(remStr)) {
                        visited.add(remStr);
                        queue.offer(remStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // Helper method to filter target by matching with sticker
    private String filterByMatching(String sticker, String inputString) {
        StringBuilder filterString = new StringBuilder();
        int index = 0;

        for (char inputCh : inputString.toCharArray()) {
            boolean found = false;
            while (index < sticker.length() && sticker.charAt(index) <= inputCh) {
                if (sticker.charAt(index++) == inputCh) {
                    found = true;
                    break;
                }
            }
            if (!found)
                filterString.append(inputCh);
        }
        return filterString.toString();
    }

    // Helper method to sort string
    private String sortString(String input) {
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        return new String(inputArr);
    }
}