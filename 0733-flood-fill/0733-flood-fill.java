class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initc = image[sr][sc];
        int[][] ans = image;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        dfs(sr, sc, ans, image, dirs,color,initc);
        return ans;
    }
    private void dfs(int sr,int sc, int[][] ans,int[][] image,int[][] dirs,int color,int initc){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int[] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == initc && ans[nr][nc] != color){
                dfs(nr,nc,ans,image,dirs,color,initc);
            }
        }
    }
}