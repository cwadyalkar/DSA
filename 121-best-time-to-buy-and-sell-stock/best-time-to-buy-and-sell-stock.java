class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int price : prices){
            if(price < min_price){
                min_price = price;
            }
            else{
            profit = Math.max(profit,price - min_price);
            }
        }

        return profit;
    }
}