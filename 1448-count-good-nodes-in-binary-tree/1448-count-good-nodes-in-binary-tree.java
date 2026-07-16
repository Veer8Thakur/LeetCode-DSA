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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        return DFS(root, Integer.MIN_VALUE);
    }
    public int DFS(TreeNode node, int maxVal){
        if(node == null) return 0;
        // int cnt = 0;
        if(maxVal <= node.val) cnt++;
        maxVal = Math.max(maxVal, node.val);

        DFS(node.left, maxVal);
        DFS(node.right, maxVal);

        return cnt;
    }
}