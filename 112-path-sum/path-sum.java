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
    int sum  = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }
    public boolean dfs(TreeNode root,int targetSum){
        if(root == null) return false;
        sum = sum + root.val;
        if(root.left  == null && root.right == null && sum == targetSum) return true;
        boolean left = dfs(root.left,targetSum);
        boolean right = dfs(root.right,targetSum);
        sum = sum - root.val;
        return left || right;
    }
}