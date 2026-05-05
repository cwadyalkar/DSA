class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int end = 0; end < n; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                minLen = Math.min(end - start + 1, minLen);
                sum = sum - nums[start];
                start++;

            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}