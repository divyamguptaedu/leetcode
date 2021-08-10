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




