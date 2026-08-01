class Solution {
    private void dfs(int node, boolean[] vis,int[][] isConnected){
        vis[node] = true;
        for(int i = 0;i< isConnected[node].length;i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(i,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0;i <isConnected.length;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                count++;
            }
        }
        return count;
    }
}