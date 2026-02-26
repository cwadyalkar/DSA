class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i = 0;i < ans.length;i++){
            int maxValue = Integer.MIN_VALUE;
            int maxKey = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){ 
                if(entry.getValue() > maxValue){
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            ans[i] = maxKey;
            map.remove(maxKey);
            
        }
      
        return ans;
    }
}