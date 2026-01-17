class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = Integer.MIN_VALUE;
        int buy = 0;
        for (int sell = 0; sell < prices.length; sell++) {
              if(prices[sell] < prices[buy]){
                buy = sell;
            }
            profit = Math.abs(prices[buy]-prices[sell]);
            maxProfit = Math.max(maxProfit,profit);
          
        }
        return maxProfit;
    }
}