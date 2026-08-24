class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Best profit if we sell today
            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            // Update minimum buying price
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
