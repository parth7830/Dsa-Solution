class Solution {
    private static int[][] dp;
    private static int solver(int i1,int i2,int m,int n,int[][] dirs,int[][] mat){
        if(i1 > m-1 || i2 > n-1)return 0;
        if(i1 == m-1 && i2 == n-1 && mat[m-1][n-1] != 1){
            return 1;
        }
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(mat[i1][i2] == 1) return 0;
        int fs = solver(i1 + dirs[0][0],i2 + dirs[0][1],m,n,dirs,mat);
        int ss = solver(i1 + dirs[1][0],i2 + dirs[1][1],m,n,dirs,mat);
        return dp[i1][i2] = fs + ss;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dirs = {{0,1},{1,0}};
        dp = new int[m][n];
        for(int[] row : dp)Arrays.fill(row,-1);
        return solver(0,0,m,n,dirs,obstacleGrid);
    }
}