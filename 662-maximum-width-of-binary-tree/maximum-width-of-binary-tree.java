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
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node,int index) {
            this.node = node;
             this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.offer(new Pair(root,0));


        while(!queue.isEmpty()){
                int size = queue.size();
                int firstIndex = queue.peek().index;
                int lastIndex = firstIndex;
                

            for(int i = 0;i < size;i++){
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index - firstIndex;

                if(i == size - 1){
                    lastIndex = index;
                }
                if(node.left != null){
                queue.offer(new Pair(node.left,2 * index));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right,2 * index + 1));
                }
            }
            maxWidth = Math.max(maxWidth,lastIndex+1);
        }
        return maxWidth;
    }
}