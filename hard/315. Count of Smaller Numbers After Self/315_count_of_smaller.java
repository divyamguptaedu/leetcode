public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len;
        List<Integer> result = new ArrayList<>();
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        Integer[] temp = new Integer[len];
        BST bst = new BST();
        for (int i = len - 1; i >= 0; i--) {
            temp[i] = bst.insert(nums[i]);
        }
        result.addAll(Arrays.asList(temp));
        return result;
    }
    
    private static class BST {
        private Node root;
        
        private int insert(int val) {
            int sCnt = 0;
            if (root == null) {
                root = new Node(val);
                return sCnt;
            }
            Node cur = root;
            while (true) {
                if (cur.val < val) {
                    sCnt += cur.lCnt + cur.selfCnt;
                    if (cur.right == null) {
                        cur.right = new Node(val);
                        return sCnt;
                    }
                    else {
                        cur = cur.right;
                    }
                }
                else if (cur.val > val) {
                    cur.lCnt++;
                    if (cur.left == null) {
                        cur.left = new Node(val);
                        return sCnt;
                    }
                    else {
                        cur = cur.left;
                    }
                }
                // equal
                else {
                    sCnt += cur.lCnt;
                    cur.selfCnt++;
                    return sCnt;
                }
            }
        }
    }
    
    private static class Node {
        private int val;
        private Node left;
        private Node right;
        // size for left sub-tree
        private int lCnt;
        // cnt for self occurances
        private int selfCnt;
        
        private Node(int val) {
            this.val = val;
            selfCnt = 1;
        }
    }
}