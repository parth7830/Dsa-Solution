class Solution {
    private static int[][] dp;

    private static int count(int[] prices, int n, int ind, int day) {
        if (ind >= n)
            return 0;
        if (dp[ind][day] != -1)
            return dp[ind][day];
        if (day == 1) {
            return dp[ind][day] = Math.max(-prices[ind] + count(prices, n,  ind + 1, 0),
                    0 + count(prices, n, ind + 1, 1));
        } else {
            return dp[ind][day] = Math.max(prices[ind] + count(prices, n,  ind + 2, 1),
                    0 + count(prices, n, ind + 1, 0));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return count(prices,n,0,1);
    }
}