class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int x : nums) {
            if (valueMap.get(x) == null) {
                valueMap.put(x, 1);
            } else {
                valueMap.put(x, valueMap.get(x) + 1);
            }
        }
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int y : valueMap.keySet()) {
            keyMap.put(valueMap.get(y), y);
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int z : keyMap.keySet()) {
            array.add(z);
        }
        MaxHeap heap = new MaxHeap(array);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (keyMap.get(heap.remove()));
        }
        return result;
    }
}





















    // public int uniquePaths(int m, int n) {
    //     int[] dp = new int[n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (i == 0 || j == 0) {
    //                 dp[j] = 1;
    //             } else {
    //                 dp[j] = dp[j] + dp[j - 1];
    //             }
    //         }
    //     }
    //     return dp[n - 1];
    // }


// class Solution {
//     HashMap<Integer,Integer> map=new HashMap<>();
//     public int numTrees(int n) {
//         if(n==0 || n==1)
//             return 1;
//         if(map.containsKey(n))
//             return map.get(n);
        
//         int c=0;
//         for(int i=1;i<=n;i++)
//         {
//            c+=numTrees(i-1)*numTrees(n-i);    
//         }
//         map.put(n,c);
//         return map.get(n);
//     }
// }

// class Solution {
//     int preorderIndex;
//     Map<Integer, Integer> inorderIndexMap;
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         preorderIndex = 0;
//         // build a hashmap to store value -> its index relations
//         inorderIndexMap = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             inorderIndexMap.put(inorder[i], i);
//         }

//         return arrayToTree(preorder, 0, preorder.length - 1);
//     }

//     private TreeNode arrayToTree(int[] preorder, int left, int right) {
//         // if there are no elements to construct the tree
//         if (left > right) return null;

//         // select the preorder_index element as the root and increment it
//         int rootValue = preorder[preorderIndex++];
//         TreeNode root = new TreeNode(rootValue);

//         // build left and right subtree
//         // excluding inorderIndexMap[rootValue] element because it's the root
//         root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
//         root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
//         return root;
//     }
// }