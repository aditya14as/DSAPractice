class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean[] vis = new boolean[m];
        boolean[] pvis = new boolean[m];
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            if(vis[i]==false){
                dfs(graph,i,vis,pvis,ans);
            }
        }
        List<Integer> list =new ArrayList<>();
        for(int i=0; i<ans.length; i++){
            if(ans[i]==1){
                list.add(i);
            }
        }
        return list;
    }
    public boolean dfs(int[][] graph,int i, boolean[] vis, boolean[] pvis,  int[] ans){
        
        vis[i]=true;
        pvis[i]=true;
        ans[i]=0;
        for(int j=0; j<graph[i].length; j++){
            if(vis[graph[i][j]]==false){
                if(dfs(graph,graph[i][j],vis,pvis,ans)) return true;
            }else{
                if(pvis[graph[i][j]]){
                    return true;
                }
            }

        }
        ans[i]=1;
        pvis[i]=false;
        return false;
    }
}