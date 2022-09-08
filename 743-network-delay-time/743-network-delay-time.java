class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        k--;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]-1).add(new int[]{times[i][1]-1,times[i][2]});
        }
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            Arrays.fill(cost,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(k,0));
        cost[k]=0;
        int idx = 0;
        while(q.size()>0){
            Pair p = q.remove();
            idx++;
            int node = p.node;
            int time = p.time;
            
            for(int j=0; j<adj.get(node).size(); j++){
                int next = adj.get(node).get(j)[0];
                int ntime = adj.get(node).get(j)[1];
                if(time+ntime<cost[next]){
                    q.add(new Pair(next,time+ntime));
                    cost[next]=time+ntime;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(cost[i],ans);
        }
        return ans== Integer.MAX_VALUE? -1 : ans;
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