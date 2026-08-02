class Solution {
    private boolean hasCycle(int node,List<List<Integer>> adj,boolean[] vis,boolean[] stack){
        vis[node] = true;
        stack[node] = true;
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(hasCycle(n,adj,vis,stack))return true;
            }
            else if(stack[n]){
                return true;
            }
        }
        stack[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(!vis[i]){
                if(hasCycle(i,adj,vis,inStack)) return false;
            }
        }
        return true;
    }
}