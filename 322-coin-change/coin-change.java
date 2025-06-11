class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -2);
        return recursion(coins, amount, dp);

    }

    public int recursion(int[] coins, int amount, int dp[]) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != -2) {
            return dp[amount];
        }

        int min  = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = recursion(coins,amount-coin,dp);
            if(res >= 0 && res < min){
                min = res + 1;

            }
        }
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];


        // have to re solve one more time
    }
}