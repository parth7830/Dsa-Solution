class Solution {
    private static int[][] dp;
    private static int count(int[] prices, int n, int fee, int ind, int day){
        if(ind == n) return 0;
        if(dp[ind][day] != -1) return dp[ind][day];
        if(day == 1){
            return dp[ind][day] = Math.max(-prices[ind] - fee + count(prices,n,fee, ind + 1,0),0+count(prices,n,fee,ind+1,1));
        }else{
            return dp[ind][day] = Math.max(prices[ind] + count(prices,n,fee, ind + 1,1),0+count(prices,n,fee,ind+1,0));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return count(prices,n,fee,0,1);
    }
}