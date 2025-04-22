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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return build(0, n - 1, 0, n - 1, preorder, postorder);
    }

    private TreeNode build(int preStart, int preEnd, int postStart, int postEnd, int[] preorder, int[] postorder) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd)
            return root;

        int leftRootVal = preorder[preStart + 1];
        int index = map.get(leftRootVal);
        int leftSize = index - postStart + 1;

        root.left = build(preStart + 1, preStart + leftSize, postStart, index, preorder, postorder);
        root.right = build(preStart + leftSize + 1, preEnd, index + 1, postEnd - 1, preorder, postorder);

        return root;
    }
}