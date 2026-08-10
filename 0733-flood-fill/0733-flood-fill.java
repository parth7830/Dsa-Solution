class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initc = image[sr][sc];
        int[][] ans = image;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        while(!q.isEmpty()){
            ans[sr][sc] = color;
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == initc && ans[nr][nc] != color){
                        ans[nr][nc] = color;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return ans;
    }
}