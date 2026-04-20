class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
      if(root.left == null && root.right == null && root.val == targetSum) return true;
      int remaining = targetSum - root.val;
      boolean leftSubtree =  hasPathSum(root.left,remaining);
      boolean rightSubtree =  hasPathSum(root.right,remaining);   
      if(leftSubtree || rightSubtree){
        return true;
      }  else{
        return false;
      }  
    }
}