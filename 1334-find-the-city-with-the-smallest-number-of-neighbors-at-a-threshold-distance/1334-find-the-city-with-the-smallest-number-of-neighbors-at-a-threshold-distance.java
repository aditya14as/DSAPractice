class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        int[][] dis = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    dis[i][j]=0;
                }else{
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<edges.length; i++){
            dis[edges[i][0]][edges[i][1]]=edges[i][2];
            dis[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dis[i][k]!=Integer.MAX_VALUE && dis[k][j]!=Integer.MAX_VALUE)
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(dis[i][j]<=d && i!=j){
                    count++;
                }
            }
            if(count<=min){
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}