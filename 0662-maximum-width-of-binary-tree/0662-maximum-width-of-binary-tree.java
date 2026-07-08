/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;

        // queue stores {node, index}
        Queue<long[]> indexQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.offer(root);
        indexQueue.offer(new long[]{1});   // root index = 1

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                long idx      = indexQueue.poll()[0];

                // normalize: subtract first index of this level
                if (i == 0) first = idx;
                long normalizedIdx = idx - first;   // prevents overflow
                if (i == size - 1) last = normalizedIdx;

                // push children with their indices
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(new long[]{2 * normalizedIdx});
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(new long[]{2 * normalizedIdx + 1});
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - 0 + 1));
        }

        return maxWidth;
    }
}