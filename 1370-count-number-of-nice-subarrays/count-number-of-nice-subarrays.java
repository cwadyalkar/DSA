class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0,1);
        for(int num : nums){
            prefixSum = prefixSum + (num % 2);
            if(map.containsKey(prefixSum - k)){
                count = count + map.get(prefixSum - k);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }
        return count;

    }
}