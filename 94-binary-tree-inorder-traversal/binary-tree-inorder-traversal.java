class Solution {
    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
}