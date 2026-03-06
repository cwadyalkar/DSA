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
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstIndex = queue.peek().index;
            int lastIndex = firstIndex;
                
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode curr = pair.node;
                int index = pair.index;
               
                if(i == 0){
                    firstIndex = index;
                }

                if(i == size - 1){
                    lastIndex = index;
                }


                if(curr.left != null){
                    queue.offer(new Pair(curr.left,2 * index + 1));
                }
                 if(curr.right != null){
                    queue.offer(new Pair(curr.right,2 * index + 2));
                }

            }
            maxWidth = Math.max(maxWidth,lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}