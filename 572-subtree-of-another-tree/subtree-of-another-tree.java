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
    public boolean isSameTree(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (isSameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }
}