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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currList = new LinkedList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode topEle = queue.poll();
                if (topEle.left != null) {
                    queue.offer(topEle.left);
                }
                if (topEle.right != null) {
                    queue.offer(topEle.right);
                }

                currList.add(topEle.val);

            }
            result.add(currList);

        }

        return result;

    }
}