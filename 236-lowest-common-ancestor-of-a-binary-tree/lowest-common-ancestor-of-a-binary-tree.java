/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = dfs(root, p, q);
        return node;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode leftSubtree = dfs(root.left, p, q);
        TreeNode rightSubtree = dfs(root.right, p, q);
        if (leftSubtree == null) {
            return rightSubtree;
        }
        if (rightSubtree == null) {
            return leftSubtree;
        }

        if(leftSubtree.val == p.val || leftSubtree.val == q.val && rightSubtree.val == p.val || rightSubtree.val == q.val){
            return root;
        }

        return root;
    }
}