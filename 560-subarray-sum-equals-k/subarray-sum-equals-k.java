class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max =0;
        int prefixSum= 0;
        map.put(0,1);
        for(int i = 0;i < nums.length;i++){
            prefixSum = prefixSum + nums[i];
            int ele = prefixSum - k;
            if(map.containsKey(ele)){
                max = max + map.get(ele);
            }
           map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return max;
    }
}