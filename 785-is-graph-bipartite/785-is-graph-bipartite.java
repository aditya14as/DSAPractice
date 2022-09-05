class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i=0; i<graph.length; i++){
            if(vis[i]== -1){
                if(!helper(graph,i,vis)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int[][] graph, int i, int[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i,0));
        while(q.size()>0){
            Pair p= q.remove();
            System.out.println(p);
            if(visited[p.e]==-1){
                visited[p.e]=p.level;
            }else{
                if(visited[p.e]!=p.level){
                    return false;
                }
            }
            for(int j=0; j<graph[p.e].length; j++){
                if(visited[graph[p.e][j]]==-1)
                    q.add(new Pair(graph[p.e][j],p.level+1));
            }
        }
        return true;
    }
}
class Pair{
    int e;
    int level;
    
    Pair(int e,int level){
        this.e = e;
        this.level = level;
    }
}
