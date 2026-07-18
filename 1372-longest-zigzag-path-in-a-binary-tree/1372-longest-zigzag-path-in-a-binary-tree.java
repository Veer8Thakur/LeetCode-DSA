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
        if(root == null) return 0;
        DFS(root.left, true, 1);
        DFS(root.right, false, 1);
        return max;
    }
    public void DFS(TreeNode node, boolean cameFrom, int len){
        if(node == null) return ;

        max = Math.max(max, len);
        if(cameFrom){
            DFS(node.right, false, len+1);
            DFS(node.left, true, 1);
        }
        else {
            DFS(node.left, true, len+1);
            DFS(node.right, false, 1);
        }
    }
}