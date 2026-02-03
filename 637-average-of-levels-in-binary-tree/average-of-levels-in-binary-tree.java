class Solution {
    public List<Double> averageOfLevels(TreeNode root) { 
            List<Double> list = new ArrayList<>();
            if(root == null) return list;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                double sum = 0;
                for(int i = 0;i < size;i++){
                    TreeNode currNode = queue.poll();
                    sum = sum + currNode.val;
                    if(currNode.left != null){
                        queue.offer(currNode.left);
                    }
                    if(currNode.right != null){
                        queue.offer(currNode.right);
                    }
                }
                list.add(sum/size);
            }
        return list;

        }
}