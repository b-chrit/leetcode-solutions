class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int maxProfit = 0;

        while(right < prices.length){
            if(prices[left] < prices[right]){
                int profit = 0;
                profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
                right += 1;
            }else{
                left = right;
                right += 1;
            }
        }

        return maxProfit;
    }
}