class Solution {
    public int rob1(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int state = 2; state < n + 1; state++) {
            int pick = nums[state - 1] + dp[state - 2];
            int noPick = 0 + dp[state - 1];
            dp[state] = Math.max(pick, noPick);

        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int nums1[] = new int[n - 1];
        int nums2[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i]; // nums[0] to nums[n-2]
            nums2[i] = nums[i + 1]; // nums[1] to nums[n-1]
        }
        return Math.max(rob1(nums1), rob1(nums2));
    }
}