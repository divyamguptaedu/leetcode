<img align="left" width="230" alt="main_photo" src="https://user-images.githubusercontent.com/30758479/128587549-9033ee00-62ab-4eba-b894-8c0fd2eb9d28.png">

#### Hey, I'm Divyam! 
   An aspiring tech entrepreneur and computer science undergraduate at Georgia Tech looking to expand my knowledge and revolutionize the world through new           initiatives inspired by past and present learning experiences.  <br />  <br /> 
   Connect with me on __[LinkedIn](https://www.linkedin.com/in/divyam-gupta-1875081b9/)__ <br /> 
   Reach me at divyam@gatech.edu
   
<br /> 

#### Action Plan:
| Problem No. | Name | Approach | Stated Difficulty | Personal Difficulty |
| ----------- | ---- | -------- | ----------------- | ------------------- |
| __[53](https://leetcode.com/problems/maximum-subarray/)__ | Maximum SubArray | Interated over the array to find a new maximum sum and update the old if required. | Easy | Medium |
| __[70](https://leetcode.com/problems/climbing-stairs/)__ | Climbing Stairs | Used recursion from the top of the stairs with a base case of 1 and 2 steps left. | Easy | Medium |
| __[104](https://leetcode.com/problems/maximum-depth-of-binary-tree/)__ | Maximum Depth of Binary Tree | Used recursion to go down the tree from both side simultaneously and choose the new maximum depth. | Easy | Easy |
| __[108](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)__ | Convert Sorted Array to Binary Search Tree | Used binary search approach to choose a new middle everytime and add to the BST. | Easy | Easy |
| __[160](https://leetcode.com/problems/intersection-of-two-linked-lists/)__ | Intersection of Two Linked Lists | Utilized the efficiency of hashmap data structure to find an already visited node. | Easy | Easy |
| __[169](https://leetcode.com/problems/majority-element/)__ | Majority Element | Utilized the efficiency of hashmap data structure to track the frequency of each distinct integer in the array and return when condition is fulfilled. | Easy | Easy |
| __[234](https://leetcode.com/problems/palindrome-linked-list/)__ | Palindrome Linked List | Converting the LinkedList to an array and using the pointer approach to check the pattern. | Easy | Medium |
| __[283](https://leetcode.com/problems/move-zeroes/)__ | Move Zeroes | Used simple approach to interate over the array and move the every zero to the end without making any copy of the array. | Easy | Easy |
| __[448](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)__ | Find All Numbers Disappeared in an Array | Used a hashmap to find the integers not present in the array. | Easy | Easy |
| __[543](https://leetcode.com/problems/diameter-of-binary-tree/)__ | Diameter of Binary Tree | Used recursion to calculate maximum depth from each node and update the new maximum. | Easy | Medium |
| __[617](https://leetcode.com/problems/merge-two-binary-trees/)__ | Merge Two Binary Trees | Used recursion to update the first tree based on the data found in the second tree. | Easy | Easy |
| __[46](https://leetcode.com/problems/permutations/)__ | Permutations | <strong>Initial Approach:</strong> Used recursion to freeze one element of the array and swap others in all possible ways. <br /> <strong>Better Approach:</strong> Used recursion to remove each element from the holder and add to each possible permutation answer.  | Medium | Hard |
| __[763](https://leetcode.com/problems/partition-labels/)__ | Partition Labels | Used hashmap to track the last index of each element and update start/end based on elements found in between. | Medium | Medium |
| __[22](https://leetcode.com/problems/generate-parentheses/)__ | Generate Parentheses | Used recursion to add "(" and ")" n times each in different combinations. | Medium | Medium |
| __[78](https://leetcode.com/problems/subsets/)__ | Subsets | Used for-loops to add each element in a set of old answers. | Medium | Easy |
| __[739](https://leetcode.com/problems/daily-temperatures/)__ | Daily Temperatures | <strong>Initial Approach:</strong> Used for-loops to calculate difference from the next warm day. <br /> <strong>Better Approach:</strong> Used stack to track the last index and calculate the difference if greater found. | Medium | Medium |
| __[230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)__ | Kth Smallest Element in a BST | <strong>Initial Approach:</strong> Performed in-order traversal and returned the kth element. <br /> <strong>Better Approach:</strong> Used the same approach, but stopped the traversal when kth smallest element is found. | Medium | Medium |
| __[647](https://leetcode.com/problems/palindromic-substrings/)__ | Palindromic Substrings | <strong>Initial Approach:</strong> Interated through the string and checked if it's a palindrome using pointer approach. <br /> <strong>Better Approach:</strong> Used recursion to build the isPalindrome function. Improves runtime. | Medium | Medium |
| __[347](https://leetcode.com/problems/top-k-frequent-elements/)__ | Top K Frequent Elements | <strong>Initial Approach:</strong> Created a hashmap of the frequencies and then removed the key with max freq. k times. <br /> <strong>Mediocre Approach:</strong> Used a maxHeap to sort the frequencies and then match with the key. <br /> <strong>Better Approach:</strong> Used priority queue to sort the keys based on frequencies and pop the queue k times. | Medium | Hard |
| __[48](https://leetcode.com/problems/rotate-image/)__ | Rotate Image | Used swapping and reversing technique to perform the rotation. | Medium | Medium |
| __[49](https://leetcode.com/problems/group-anagrams/)__ | Group Anagrams | Converted each string to a char array and used HashMap to store anagrams. | Medium | Medium |
| __[39](https://leetcode.com/problems/combination-sum/)__ | Combination Sum | Used recursion to find each possible combination and add to result if valid. | Medium | Medium |
| __[215](https://leetcode.com/problems/kth-largest-element-in-an-array/)__ | Kth Largest In Array | Used priority queue as max heap to store values and pop k times. | Medium | Easy |
| __[238](https://leetcode.com/problems/product-of-array-except-self/)__ | Product of Array Except Self | Formed left product and right product arrays to track result. | Medium | Medium |
| __[102](https://leetcode.com/problems/binary-tree-level-order-traversal/)__ | Binary Tree Level Order Traversal | Used queue to form each level list and add to the result. | Medium | Medium |
| __[42](https://leetcode.com/problems/trapping-rain-water/)__ | Trapping Rainwater | <strong>Initial Approach:</strong> Interate over the height array and left leftMax and rightMax each time to compute result. <br /> <strong>Better Approach:</strong> Kept track of leftMax and rightMax each time to compute result. | Hard | Hard |
| __[287](https://leetcode.com/problems/find-the-duplicate-number/)__ | Find the Duplicate Number | Used a hashmap/set to add all nums in the array and return if already added. | Medium | Easy |
| __[199](https://leetcode.com/problems/binary-tree-right-side-view/)__ | Binary Tree Right Side View | Built the result array adding all the last elements of the level order traversal. | Medium | Easy |
| __[64](https://leetcode.com/problems/minimum-path-sum/)__ | Minimum Path Sum | Used iteration of each possible path to compute sum and have the minimum at the last index. | Medium | Medium |
| __[62](https://leetcode.com/problems/unique-paths/)__ | Unique Paths | Used iteration of each possible path and incremented the count. | Medium | Medium |
| __[96](https://leetcode.com/problems/unique-binary-search-trees/)__ | Unique Binary Search Trees | Used hashmap to store maximum possible combinations and used recursion to calculate for any n. | Medium | Medium |
| __[114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)__ | Flatten Binary Tree to Linked List | Used recursion to find the previous node and set to the right, leaving all lefts as null. | Medium | Medium |
| __[105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)__ | Construct Binary Tree from Preorder and Inorder Traversal | Used the inorder indexes and preorder traversal to build the tree. | Medium | Medium |
| __[208](https://leetcode.com/problems/implement-trie-prefix-tree/)__ | Implement Trie (Prefix Tree) | Created a node with Node[26] children and used recursion to initialize each character according to the string.  | Medium | Medium |
| __[297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)__ | Serialize and Deserialize Binary Tree | Found preorder traversal and converted into a string to serialize. Split the string and form the tree from the preorder traversal.  | Hard | Medium |
| __[394](https://leetcode.com/problems/decode-string/)__ | Decode String | Used condition statements to do the tasks. Followed stack approach to save the result.  | Medium | Medium |
| __[621](https://leetcode.com/problems/task-scheduler/)__ | Task Scheduler | Used hashmap and queue to compute idle time. | Medium | Medium |
| __[11](https://leetcode.com/problems/container-with-most-water/)__ | Container With Most Water | Used two pointer approach to calculate volume between two heights. | Medium | Medium |
| __[337](https://leetcode.com/problems/house-robber-iii/)__ | House Robber III | Got level order traversal and returned maximum of alternate levels' sum. | Medium | Medium |
| __[236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)__ | Lowest Common Ancestor of a Binary Tree | Performing a traversal and returning the common ancestor. | Medium | Medium |
| __[75](https://leetcode.com/problems/sort-colors/)__ | Sort Colors | Used hashmap to store frequencies and priority queue to get ordered keys. | Medium | Medium |
| __[17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)__ | Letter Combinations of a Phone Number | Used a switch statement and got all possible combinations of the two strings. | Medium | Medium |
| __[200](https://leetcode.com/problems/number-of-islands/)__ | Number of Islands | Found all adjacent 1s and turned them into Xs and incremented the counter. Did this for all i,j. | Medium | Medium |
| __[279](https://leetcode.com/problems/perfect-squares/)__ | Perfect Squares | Used the square-root approach and then stored the minimum. | Medium | Medium |
| __[437](https://leetcode.com/problems/path-sum-iii/)__ | Path Sum III | Incremented the counter with left and right root recursion and new target sum. | Medium | Medium |
| __[295](https://leetcode.com/problems/find-median-from-data-stream/)__ | Find Median from Data Stream | <strong>Initial Approach:</strong> Formed a minHeap and computed the median by removing and adding elements each time. <br /> <strong>Better Approach:</strong> Formed a minHeap and a maxHeap to store elements and get median in O(1) time. | Hard | Medium |
| __[2](https://leetcode.com/problems/add-two-numbers/)__ | Add Two Numbers | Used a simple carry-over approach to compute the sum. | Medium | Easy |
| __[55](https://leetcode.com/problems/jump-game/)__ | Jump Game | Used a simple i + nums[i] approach to jump. | Medium | Easy |
| __[31](https://leetcode.com/problems/next-permutation/)__ | Next Permutation | Found the next bigger number by checking from the end and swapping. | Medium | Medium |
| __[45](https://leetcode.com/problems/jump-game-ii/)__ | Jump Game II | Used interation and computed the minimum steps required to reach the end. | Medium | Medium |
| __[152](https://leetcode.com/problems/maximum-product-subarray/)__ | Maximum Product Subarray | <strong>Initial Approach:</strong> Iterated over the array to choose the maximum product. <br /> <strong>Better Approach:</strong> Considered three possibilies each time and stores the result. | Medium | Medium |
| __[3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)__ | Longest Substring Without Repeating Characters | Used a hashSet to store the seen characters and computed the maximum length each time. | Medium | Medium |
| __[5](https://leetcode.com/problems/longest-palindromic-substring/)__ | Longest Palindromic Substring | Used recursion and interation to get the maximum length palindrome. | Medium | Medium |
| __[98](https://leetcode.com/problems/validate-binary-search-tree/)__ | Validate Binary Search Tree | Used recursion on each left and right node. Returned false if larger or smaller. | Medium | Easy |
| __[15](https://leetcode.com/problems/3sum/)__ | 3 Sum | Used three pointers and incremented the pointer based on result. | Medium | Medium |
| __[207](https://leetcode.com/problems/course-schedule/)__ | Course Schedule | Used the graph and queue approach to get the courses required. | Medium | Medium |
| __[416](https://leetcode.com/problems/partition-equal-subset-sum/)__ | Partition Equal Subset Sum | Iterated over the array and check each partition if it equal to subset sum. Stored the answer for faster runtime. | Medium | Medium |
| __[494](https://leetcode.com/problems/target-sum/submissions/)__ | Target Sum | <strong>Initial Approach:</strong> Recursed on all possible sums. Both increasing and decreasing. <br /> <strong>Better Approach:</strong> Stored answers to increase runtime. | Medium | Medium |
| __[438](https://leetcode.com/problems/find-all-anagrams-in-a-string/)__ | Find all anagrams in a String | <strong>Initial Approach:</strong> Stores a sorted character array and made a new one for each entry. <br /> <strong>Better Approach:</strong> Formed two lists and avoided sorting each time. | Medium | Medium |
| __[240](https://leetcode.com/problems/search-a-2d-matrix-ii/)__ | Search a 2D Matrix II | Started from the right corner and change row/colomn according to comparisons. | Medium | Medium |
| __[300](https://leetcode.com/problems/longest-increasing-subsequence/submissions/)__ | Longest Increasing Subsequence | Used binary search to find position. | Medium | Medium |
| __[128](https://leetcode.com/problems/longest-consecutive-sequence/)__ | Longest Consecutive Sequence | Used hashmap and ignored the duplicates. | Medium | Medium |
| __[148](https://leetcode.com/problems/sort-list/)__ | Sort List | Used simple merge sort. | Medium | Medium |
| __[72](https://leetcode.com/problems/edit-distance/)__ | Edit Distance | Chose a minimum each time and used storage for optimization. | Medium | Medium |
| __[239](https://leetcode.com/problems/sliding-window-maximum/)__ | Sliding Window Maximum | Used a queue to find maximum each time add to the result. | Medium | Medium |
| __[19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)__ | Remove Nth Node From End of List | Used two pointers to reach the node before the one to be removed. | Medium | Easy |
| __[33](https://leetcode.com/problems/search-in-rotated-sorted-array/)__ | Search in Rotated Sorted Array | Used the binary search algorithm for logn time. | Medium | Easy |
| __[189](https://leetcode.com/problems/rotate-array/)__ | Rotate Array | Used reversing the array approach to do in-place rotation. | Medium | Easy |
| __[146](https://leetcode.com/problems/lru-cache/)__ | LRU Cache | Used the hashmap data structure for faster runtime. | Medium | Easy |
| __[79](https://leetcode.com/problems/word-search/)__ | Word Search | Iterated over the array and checked the adjacents to find the word. | Medium | Easy |
| __[34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)__ | Find First and Last Position of Element in Sorted Array | Used while loops to search for the first and last occurance of the element given. | Medium | Easy |
| __[322](https://leetcode.com/problems/coin-change/)__ | Coin Change | Used brute-force recursion with optimization to increase runtime. | Medium | Medium |
| __[221](https://leetcode.com/problems/maximal-square/)__ | Maximal Square | Used brute-force with optimization to increase runtime. | Medium | Medium |
| __[142](https://leetcode.com/problems/linked-list-cycle-ii/)__ | Linked List Cycle II | <strong>Initial Approach:</strong> Used a hashset for storing seen elements. <br /> <strong>Better Approach:</strong> Used the two pointer faster approach to detect the cycle. | Medium | Medium |
| __[56](https://leetcode.com/problems/merge-intervals/)__ | Merge Intervals | Checked the next's [0] index and compared with previous's [1] index. | Medium | Medium |
| __[139](https://leetcode.com/problems/word-break/)__ | Word Break | Get substring index and recurse. | Medium | Medium |
| __[138](https://leetcode.com/problems/copy-list-with-random-pointer/)__ | Copy List with Random Pointer | Used hashmap to store all new created nodes and then just tracked the next and random pointers. | Medium | Medium |
| __[198](https://leetcode.com/problems/house-robber/)__ | House Robber | Used a simple two pointer approach to check the houses. | Medium | Medium |
| __[560](https://leetcode.com/problems/subarray-sum-equals-k/)__ | Subarray Sum Equals K | Used a hashmap to store answers and recalculate sum. | Medium | Medium |
| __[23](https://leetcode.com/problems/merge-k-sorted-lists/submissions/)__ | Merge k Sorted Lists | Added all the nodes to a priority queue and removed the top one by one creating a new LinkedList. | Hard | Medium |
| __[85](https://leetcode.com/problems/maximal-rectangle/submissions/)__ | Maximal Rectangle | Used the Largest Rectangle in Histogram approach to find the maximal area each time. | Hard | Medium |
| __[84](https://leetcode.com/problems/largest-rectangle-in-histogram/)__ | Largest Rectangle in Histogram | Used a stack to calculate the maximum area each time. | Hard | Medium |
| __[124](https://leetcode.com/problems/binary-tree-maximum-path-sum/)__ | Binary Tree Maximum Path Sum | Used recursion to choose the maximum of path each time. | Hard | Medium |
| __[4](https://leetcode.com/problems/median-of-two-sorted-arrays/)__ | Median of Two Sorted Arrays | Calculated the two medians and their mean. | Hard | Medium |





