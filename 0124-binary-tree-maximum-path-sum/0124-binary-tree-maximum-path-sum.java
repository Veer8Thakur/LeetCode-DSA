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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return max;
    }
    public int DFS(TreeNode node){
        if(node == null) return 0;
        int left = DFS(node.left);
        int right = DFS(node.right);

        int temp = Math.max(node.val, node.val + Math.max(left + right, Math.max(left, right)));
        max = Math.max(max, temp);

        return Math.max(node.val ,node.val + Math.max(left, right));
    }
}