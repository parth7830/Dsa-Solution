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
    private int matchingNodeCount = 0;

    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return matchingNodeCount;
    }

    // Helper method returns an array: [sumOfSubtree, countOfNodesInSubtree]
    private int[] traverse(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // Base case: sum = 0, count = 0
        }

        // Recursively compute values for left and right subtrees
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);

        // Calculate current subtree sum and node count
        int currentSum = node.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];

        // Check if current node's value matches the integer average of its subtree
        if (node.val == (currentSum / currentCount)) {
            matchingNodeCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}