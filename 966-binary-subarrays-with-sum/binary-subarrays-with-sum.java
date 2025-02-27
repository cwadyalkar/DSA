class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for (int num : nums) {
            prefixSum = prefixSum + num;
            if (map.containsKey(prefixSum - goal)) {
                count = count + map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }
}