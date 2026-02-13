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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
        boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.val == x) {
                    foundX = true;
                }
                if (currNode.val == y) {
                    foundY = true;
                }
                if (currNode.left != null && currNode.right != null) {
                    if ((currNode.left.val == x && currNode.right.val == y)
                            || (currNode.left.val == y && currNode.right.val == x))
                        return false;

                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }

            }
            if (foundX && foundY)
                return true;
            if (foundX || foundY)
                return false;

        }

        return false;
    }
}