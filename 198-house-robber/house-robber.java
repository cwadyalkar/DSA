class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int dp[] = new int[n];
    //     Arrays.fill(dp, -1);
    //     return recursion(nums, n - 1, dp);
    // }

    // public int recursion(int[] nums, int index, int dp[]) {
    //     if (index == 0) {
    //         return nums[0];
    //     }
    //     if (index < 0) {
    //         return 0;
    //     }

    //     if (dp[index] != -1)
    //         return dp[index];

    //     int pick = nums[index] + recursion(nums, index - 2, dp);
    //     int noPick = 0 + recursion(nums, index - 1, dp);
    //     dp[index] = Math.max(pick, noPick);
    //     return dp[index];
    // }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int state = 2; state < n + 1; state++) {
            int pick = nums[state - 1] + dp[state - 2];
            int noPick = 0 + dp[state - 1];
            dp[state] = Math.max(pick, noPick);

        }
        return dp[n];
    }

}