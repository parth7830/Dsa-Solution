class Solution {
    // private static int count(int[] prices, int i, int day) {
    //     if (i == prices.length)
    //         return 0;
    //     int maxi = 0;
    //     if (day == 1) {
    //         int take = -prices[i] + count(prices, i + 1, 0);
    //         int skip = count(prices, i + 1, 1);
    //         return Math.max(skip, take);
    //     } else {
    //         int sell = prices[i] + count(prices, i + 1, 1);
    //         int skip = count(prices, i + 1, 0);
    //         return Math.max(skip, sell);
    //     }
    // }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int take = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    dp[i][buy] = Math.max(skip, take);
                } else {
                    int sell = prices[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    dp[i][buy] = Math.max(skip, sell);
                }
            }
        }
        return dp[0][1];
    }
}