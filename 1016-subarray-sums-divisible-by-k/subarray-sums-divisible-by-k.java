class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + nums[i];
            int remainder = prefixSum % k;
            if(remainder < 0) remainder = remainder + k;
            if(map.containsKey(remainder)){
                count = count + map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}