class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int total = 0;

        for (int num : nums) {
            prefix = prefix + num;
            if (map.containsKey(prefix - k)) {
                total = total + map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);

        }

        return total;

    }
}