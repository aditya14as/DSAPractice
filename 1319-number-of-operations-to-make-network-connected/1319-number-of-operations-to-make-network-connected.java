class Solution {
    int count=0;
    public int makeConnected(int n, int[][] con) {
        if(con.length<n-1){
            return -1;
        }
        int[] rank = new int[n];
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            rank[i]=0;
            parent[i]=i;
        }
        for(int i=0; i<con.length; i++){
            int u = con[i][0];
            int v = con[i][1];
            union(parent,rank,u,v);
        }
        return n-count-1;
    }
    public int findParent(int[] parent, int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=findParent(parent,parent[u]);
    }
    public void union(int[] parent, int[] rank , int u , int v){
        u = findParent(parent,u);
        v = findParent(parent,v);
        if(u!=v){
            if(rank[u]<rank[v]){
                parent[u]=v;
            }else if(rank[v]<rank[u]){
                parent[v]=u;
            }
            else{
                parent[u]=v;
                rank[v]++;
            }
            count++;
        }
    }
}