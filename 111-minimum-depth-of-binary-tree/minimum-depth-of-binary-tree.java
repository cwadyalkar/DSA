class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);

        int leftSubtree = minDepth(root.left);
        int rightSubtree = minDepth(root.right);

        return 1 + Math.min(leftSubtree, rightSubtree);
    }
}