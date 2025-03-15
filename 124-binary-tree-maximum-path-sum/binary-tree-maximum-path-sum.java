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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }
    public int maxPath(TreeNode node){
        if(node == null) return 0;
        
        int leftMax = Math.max(maxPath(node.left),0);
        int rightMax = Math.max(maxPath(node.right),0);

        int sum = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum,sum);

        return node.val + Math.max(leftMax,rightMax);
    }
}