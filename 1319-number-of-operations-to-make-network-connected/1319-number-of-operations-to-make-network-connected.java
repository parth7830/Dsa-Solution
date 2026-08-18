class Solution {
    private int[] parent;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1;
        parent = new int[n];
        for(int i = 0;i<n;i++) parent[i] = i;
        for(int[] c : connections){
            union(c[0], c[1]);
        }
        Set<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            hs.add(find(i));
        }
        return hs.size() - 1;
    }
    private int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x]; 
        }
        return x;
    }
    private void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx != ry){
            parent[rx] = ry;
        }
    }
}