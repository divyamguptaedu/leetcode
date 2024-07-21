class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parent.put(node.left.val, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right.val, node);
                    queue.add(node.right);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        queue.add(target);
        while (k > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node.val);
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.offer(node.right);
                }

                if (parent.containsKey(node.val) && !visited.contains(parent.get(node.val).val)) {
                    queue.offer(parent.get(node.val));
                }
            }
            k--;
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }
}