class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[m-1][n-1] == 1)return 0;
        dp[m-1][n-1] = 1;
        for(int i1 = m-1;i1>=0;i1--){
            for(int i2 = n-1;i2>=0;i2--){
                if(i1 == m-1 && i2 == n-1) continue;
                if(obstacleGrid[i1][i2] == 1) continue;
                int fs = i1 + 1 < m ? dp[i1+1][i2] : 0;
                int ss = i2 + 1 < n ? dp[i1][i2+1] : 0;
                dp[i1][i2] = fs + ss;
            }
        }
        return dp[0][0];
    }
}