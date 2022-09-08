class Solution {
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[] { roads[i][1], roads[i][2] });
            adj.get(roads[i][1]).add(new int[] { roads[i][0], roads[i][2] });
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));
        long[] ways = new long[n];
        ways[0] = 1;
        while(q.size()>0){
            Pair p = q.remove();
            int node = p.node;
            int time = p.time;
            for(int j=0; j<adj.get(node).size(); j++){
                int next = adj.get(node).get(j)[0];
                int ntime = adj.get(node).get(j)[1];
                if(time+ntime<cost[next]){
                    q.add(new Pair(next,time+ntime));
                    cost[next]=time+ntime;
                    ways[next]=ways[node];
                }
                else if(time+ntime==cost[next]){
                    ways[next]=(ways[node]+ways[next])%mod;
                }
            }
        }
        return (int)ways[n-1];
        
    }
}
   
class Pair implements Comparable<Pair>{
    int node;
    int time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
    public int compareTo(Pair o){
        return this.time - o.time;
    }
}