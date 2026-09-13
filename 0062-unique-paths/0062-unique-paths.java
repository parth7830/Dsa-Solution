class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i1 = m-1;i1>=0;i1--){
            for(int i2 = n-1;i2>=0;i2--){
                if(i1 == m-1 && i2 == n-1) continue;
                int fs = i1+1 < m ? dp[i1+1][i2] : 0;
                int ss = i2+1 < n ? dp[i1][i2+1] : 0;
                dp[i1][i2] = fs + ss;
            }
        }
        return dp[0][0];
    }
}