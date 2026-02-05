/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null) return list;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                size--;
                if (size == 0) {
                    list.add(currNode.val);

                }
            }

        }
        return list;

    }
}