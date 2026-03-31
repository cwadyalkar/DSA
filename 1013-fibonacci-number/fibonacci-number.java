class Solution {
    public int fib(int n) {
        // using DP
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return find(n, dp);

    }

    public int find(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = find(n - 1, dp) + find(n - 2, dp);
        return dp[n];
    }
}