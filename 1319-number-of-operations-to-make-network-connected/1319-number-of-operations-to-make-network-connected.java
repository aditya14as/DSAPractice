class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            
            if(vis[i]==false){
                count++;
                getConnected(adj,i,vis);
            }
        }
        return count-1;
    }
    public void getConnected(List<List<Integer>> adj, int i, boolean[] vis){
        vis[i]=true;
        for(int j=0; j<adj.get(i).size(); j++){
            if(vis[adj.get(i).get(j)]==false){
                getConnected(adj,adj.get(i).get(j),vis);
            }
        }
    }
}