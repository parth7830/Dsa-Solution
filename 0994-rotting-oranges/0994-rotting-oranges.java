class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0)return 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int minutes = 0;
        while(!q.isEmpty() && fresh > 0){
            minutes++;
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dirs : dir){
                    int nr = r + dirs[0];
                    int nc = c + dirs[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < col && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return fresh == 0?minutes:-1;
    }
}