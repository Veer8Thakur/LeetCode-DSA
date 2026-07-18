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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);   // First move is to the left
        dfs(root.right, false, 1); // First move is to the right
        return max;
    }

    private void dfs(TreeNode node, boolean cameFromLeft, int length) {
        if (node == null) return;

        max = Math.max(max, length);

        if (cameFromLeft) {
            // Continue ZigZag by going right
            dfs(node.right, false, length + 1);

            // Restart from left child
            dfs(node.left, true, 1);
        } else {
            // Continue ZigZag by going left
            dfs(node.left, true, length + 1);

            // Restart from right child
            dfs(node.right, false, 1);
        }
    }
}