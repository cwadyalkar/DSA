class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int maxLen = 0;
        int prefixSum = 0;
        map.put(0,1);
        for(int i = 0;i < n;i++){
            prefixSum = prefixSum + nums[i];
            int subarraySum = prefixSum - k;
            if(map.containsKey(subarraySum)){
                maxLen = maxLen + map.get(subarraySum);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);    
        }

        return maxLen;
    }
}