class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(0);
        while (queue.size() > 0) {
            int i = queue.poll();
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
            if (leftChild[i] != -1) {
                queue.add(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                queue.add(rightChild[i]);
            }
        } 
        return set.size() == n;
    }
}