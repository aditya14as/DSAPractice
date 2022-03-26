class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] arr) {
        ArrayList<Edge>[] graph = new ArrayList[arr.length];
        for(int i=0; i<arr.length; i++){
            graph[i]= new ArrayList<>();
        }
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                graph[i].add(new Edge(i,arr[i][j]));
            }
        }
        boolean[] visited = new boolean[arr.length];
        List<Integer> inlist = new ArrayList<>();
        inlist.add(0);
        dfsTraversal(graph,0,arr.length-1,visited,inlist);
        return list;
    }
    
    public class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public List<List<Integer>> list = new ArrayList<>();
    public void dfsTraversal(ArrayList<Edge>[] graph,int src,int end,boolean[] visited,List<Integer> inlist){
        if(src==end){
            list.add(new ArrayList<>(inlist));
            return;
        }
        visited[src]=true;
        for(int i =0; i<graph[src].size(); i++){
            if(visited[graph[src].get(i).nbr]==false){
                inlist.add(graph[src].get(i).nbr);
                dfsTraversal(graph, graph[src].get(i).nbr, end,visited, inlist );
                inlist.remove(inlist.size()-1);
            }
        }
        visited[src]=false;
    }
}