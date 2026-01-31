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
    public int dfs(TreeNode root){
       if(root == null) return 0;

        int leftSubtree = dfs(root.left);
        if(leftSubtree == -1) return -1;

        int rightSubtree = dfs(root.right);
        if(rightSubtree == -1) return -1;

        if(Math.abs(leftSubtree - rightSubtree) > 1){
            return -1;
        }
        return 1 + Math.max(leftSubtree,rightSubtree);

    }
    public boolean isBalanced(TreeNode root) {
        int balanced = dfs(root);
        return balanced != -1 ? true : false;
    }

}