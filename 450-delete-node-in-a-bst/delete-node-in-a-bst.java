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
    public TreeNode findPredecessor(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        else{
        // For Deleting the Leaf Node
        if(root.left == null && root.right == null){
            return null;
        }

        // For Deleting the Single Child Node
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            // For Deleting the Two Child Node
            // Inorder Predecessor -> Largest Value in LeftMost Tree

            TreeNode node = findPredecessor(root.left);
            root.val = node.val;
            root.left = deleteNode(root.left,node.val);

        }

        }

        return root;
    }
}