//I iterated through the buildings from right to left. 
//If a building can see the ocean without obstructions (i.e., all the buildings to its right have a smaller height), 
//I added its index to a list. While traversing, 
//I kept track of the maximum building height encountered so far. 
//If a building's height exceeded this maximum, it implies that the current building can see the ocean, 
//so I added its index to the list. 
//Finally, I transferred the indices from the list to the answer array in reverse order to 
//maintain the correct order of buildings with an ocean view.

//Time: O(n) where n is the number of buildings.
//Space: O(n)
class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        int maxHeight = -1;

        for (int current = n - 1; current >= 0; --current) {
            // If there is no building higher (or equal) than the current one to its right,
            // push it in the list.
            if (maxHeight < heights[current]) {
                list.add(current);

                // Update max building till now.
                maxHeight = heights[current];
            }
        }

        // Push building indices from list to answer array in reverse order.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }

        return answer;
    }
}