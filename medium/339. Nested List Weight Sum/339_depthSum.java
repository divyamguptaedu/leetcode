//I calculated the weighted sum of integers in a nested list, 
//where the weight is determined by the depth of the integer. 
//I used a breadth-first search (BFS) approach with a queue to traverse the nested list level by level. 
//For each integer encountered, I multiplied its value by its depth and added it to the total sum. 
//If an element in the nested list was itself a list, I added its elements to the queue for further traversal. 
//This way, I iterated through all nested levels, accumulating the weighted sum of integers.

//Time: O(n) where n is the total number of integers across all levels of nested list.
//Space: O(d) where d is the max depth of the nested list.

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
