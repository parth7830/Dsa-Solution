class Solution {
    private static int[] dp;

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
        dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int j = coin ; j<=amount;j++){
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }
}