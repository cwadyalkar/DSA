class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long sum = 0;
        long maxSum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            sum = sum + nums[end];

            if (end - start + 1 > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                sum = sum - nums[start];
                start++;
            }
            
            if (end - start + 1 == k && map.size() == k) {
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}