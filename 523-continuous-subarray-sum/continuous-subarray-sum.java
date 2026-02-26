class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefixSum = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            prefixSum = prefixSum + nums[i];
            if(map.containsKey(prefixSum % k)){
                int index = map.get(prefixSum % k);
                if(i-index >= 2){
                    return true;
                }

            }else{
                map.put(prefixSum % k,i);
            }
            
           
        }
        return false;
    
    }
}