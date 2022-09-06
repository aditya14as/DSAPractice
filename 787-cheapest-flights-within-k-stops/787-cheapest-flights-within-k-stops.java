class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        int[] costs = new int[n], stops = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        costs[src] = 0;
        stops[src] = 0;
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
     
        q.add(new Pair(src,0,0));
        while(q.size()>0){
            Pair p = q.remove();
            if(p.n==dst){
                return p.w;
            }
            if(p.s==k){
                continue;
            }
            for(int i=0; i<adj.get(p.n).size(); i++){
                int next = adj.get(p.n).get(i)[0];
                int cost = adj.get(p.n).get(i)[1];
                if(p.w+cost<costs[next] || p.s+1<stops[next]){
                    q.add(new Pair(next,p.w+cost,p.s+1));
                    costs[next]=p.w+cost;
                    stops[next]=p.s+1;
                }
            }
        }
        return -1;
    }
}
class Pair implements Comparable<Pair>{
    int n;
    int w;
    int s;
    Pair(int n, int w, int s){
        this.n = n;
        this.w = w;
        this.s = s;
    }
    public int compareTo(Pair o){
        return this.w-o.w;
    }
}