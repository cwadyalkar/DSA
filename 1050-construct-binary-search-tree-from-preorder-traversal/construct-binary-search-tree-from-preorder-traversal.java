/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode buildBstFromPreorder(int[] preorder, int upper_bound) {
    
        if (index == preorder.length || preorder[index] > upper_bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = buildBstFromPreorder(preorder, root.val);
        root.right = buildBstFromPreorder(preorder, upper_bound);
        return root;
    }

 
}