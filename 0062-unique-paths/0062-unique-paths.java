class Solution {
    private static int[][] memo;
    private static int solver(int i1,int i2,int m, int n,int[][] dirs){
        if(i1 > m-1 || i2 > n-1) return 0;
        if(i1 == m-1 && i2 == n-1){
            return 1;
        }
        if(memo[i1][i2] != -1) return memo[i1][i2];
        int fs = solver(i1 + dirs[0][0],i2 + dirs[0][1],m, n ,dirs);
        int ss = solver(i1 + dirs[1][0],i2 + dirs[1][1], m, n, dirs);
        return memo[i1][i2] = fs + ss;
    }
    public int uniquePaths(int m, int n) {
        int ind1 = 0;
        int ind2 = 0;
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int[][] dirs = {{1,0},{0,1}};
        return solver(ind1,ind2,m,n,dirs);
    }
}