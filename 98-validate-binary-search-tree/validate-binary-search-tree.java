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
    public boolean isValidBST(TreeNode root) {
        long minRange = Long.MIN_VALUE;
        long maxRange = Long.MAX_VALUE;
        return isValidate(root.left,minRange,root.val) && isValidate(root.right,root.val,maxRange);
    }
    public boolean isValidate(TreeNode root,long minRange,long maxRange){
        if(root == null) return true;
        if(root.val >= maxRange){
            return false;
        }
        if(root.val <= minRange){
            return false;
        }
        return isValidate(root.left,minRange,root.val) && isValidate(root.right,root.val,maxRange);


    }
}