class Solution {
    private static int[][] dp;

    // private static int count(int[] prices, int n, int fee, int ind, int day) {
    //     if (ind == n)
    //         return 0;
    //     if (dp[ind][day] != -1)
    //         return dp[ind][day];
    //     if (day == 1) {
    //         return dp[ind][day] = Math.max(-prices[ind] - fee + count(prices, n, fee, ind + 1, 0),
    //                 0 + count(prices, n, fee, ind + 1, 1));
    //     } else {
    //         return dp[ind][day] = Math.max(prices[ind] + count(prices, n, fee, ind + 1, 1),
    //                 0 + count(prices, n, fee, ind + 1, 0));
    //     }
    // }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int day = 0; day < 2; day++) {
                if (day == 1) {
                    dp[ind][day] = Math.max(-prices[ind] - fee + dp[ind + 1][0],
                            0 + dp[ind + 1][1]);
                } else {
                    dp[ind][day] = Math.max(prices[ind] + dp[ind + 1][1],
                            0 + dp[ind + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}