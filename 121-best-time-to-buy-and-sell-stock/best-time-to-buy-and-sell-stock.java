class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            minPrice = Math.min(minPrice,price);
            int currProfit = price - minPrice;
            profit = Math.max(profit,currProfit);
        }
        return profit;
    }
}