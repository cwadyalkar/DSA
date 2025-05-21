class Solution {
    int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(nums, k, 0, new HashMap<>());
        return count;
    }

    public void backtrack(int[] nums, int k, int index, HashMap<Integer, Integer> freqMap) {
        if (index == nums.length) {
            if (!freqMap.isEmpty())
                count++;
            return;
        }
        backtrack(nums, k, index + 1, freqMap);
        int num = nums[index];
        if (freqMap.getOrDefault(num - k, 0) == 0) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            backtrack(nums, k, index + 1, freqMap);
            freqMap.put(num, freqMap.get(num) - 1);
            if (freqMap.get(num) == 0)
                freqMap.remove(num);
        }

    }
}