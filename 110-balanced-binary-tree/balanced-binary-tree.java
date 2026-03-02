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
    int valid = 1;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return valid == 1;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        
        int leftSubtree = getHeight(root.left);
        int rightSubtree = getHeight(root.right);

       if(Math.abs(leftSubtree - rightSubtree) > 1) {
            valid = 0;
        }
        return 1 + Math.max(leftSubtree,rightSubtree);
    }
}