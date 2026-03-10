class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            prefixSum = prefixSum + num;
            int remainder = prefixSum % k;
            if(remainder < 0) remainder = remainder + k;  //to prevent negative remainder
            if(map.containsKey(remainder)){
                int freq = map.get(remainder);
                count = count + freq;
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }

        return count;
    }
}