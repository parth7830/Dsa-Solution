class Node{
    int first;
    int second;
    int third;
    Node(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = 1;      
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            Node curr = q.poll();      
            int row   = curr.first;
            int col   = curr.second;
            int steps = curr.third;
            dis[row][col] = steps;
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.offer(new Node(nr,nc,steps+1));
                }
            } 
        }
        return dis;
    }
}