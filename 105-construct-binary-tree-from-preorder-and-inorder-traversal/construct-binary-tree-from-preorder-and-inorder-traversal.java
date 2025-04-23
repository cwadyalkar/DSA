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
    int rootIndex = 0;

    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[rootIndex];
        rootIndex++;
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        if (mid > left) {
            root.left = build(preorder, left, mid - 1);
        }
        if (mid < right) {
            root.right = build(preorder, mid + 1, right);
        }
        return root;
    }
}