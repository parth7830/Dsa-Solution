class Solution {
    private static int[][] dp;

    // private static int count(int[] coins, int amount, int n, int i,int sum){
    //     if(sum == amount) return 1;
    //     if(i == n) return 0;
    //     if(dp[i][sum] != -1) return dp[i][sum];
    //     int nt = count(coins,amount,n,i+1,sum);
    //     int t = 0;
    //     if(coins[i] <= amount - sum){
    //         t = count(coins,amount,n,i,sum + coins[i]);
    //     }
    //     return dp[i][sum] = t + nt;
    // }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount + 1];
        for (int i = 0; i <= n; i++)
            dp[i][amount] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int sum = amount -1; sum >= 0; sum--) {
                int nt = dp[i + 1][sum];
                int t = 0;
                if (coins[i] <= amount - sum) {
                    t = dp[i][sum + coins[i]];
                }
                dp[i][sum] = nt + t;
            }
        }
        return dp[0][0];
    }
}