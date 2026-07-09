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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        DFS(root1, tree1);
        DFS(root2, tree2);
        return tree1.equals(tree2);
    }
    public void DFS(TreeNode node, List<Integer> leaves){
        if(node == null) return ;
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            // return ;
        }
        DFS(node.left, leaves);
        DFS(node.right, leaves);
    }
}