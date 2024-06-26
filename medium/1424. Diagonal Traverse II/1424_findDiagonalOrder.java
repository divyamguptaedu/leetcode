//We can use the sum property and solve this question. But that would require two passes, one to get sum and form groups, second to populate the result.
//A better way is to use the level order property of BFS. The level-wise nature of BFS will ensure that we visit all squares in a diagonal with identifier 
//x before we visit any square in a diagonal with identifier x + 1. This means we will visit the diagonals in the correct order.
//So, we will initialize a queue with (0, 0) and the answer list.
//While the queue is not empty, we remove from the queue, add its value to answer.
//If col == 0 and row + 1 is in bounds, we add row+1, col to the queue. 
//If col + 1 is in bounds, we add row, col + 1 to the queue.

//Time: O(n)
//Space: O(sqrt n) i.e. #elements in the longest diagonal
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.offer(new Pair(0, 0));
        List<Integer> ans = new ArrayList();
        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            ans.add(nums.get(row).get(col));
            
            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new Pair(row + 1, col));
            }
            
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new Pair(row, col + 1));
            }
        }
        
        // Java needs conversion
        int[] result = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}