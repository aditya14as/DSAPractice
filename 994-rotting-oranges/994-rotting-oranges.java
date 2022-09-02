class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int rotten=0;
        int fresh = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    rotten++;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
                
            }
        }
        if(fresh==0){
            return 0;
        }
        if(q.size()==0){
            return -1;
        }
        int ctime = 0;
        int f = 0;
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};
        while(q.size()>0){
            int n= q.size();
            ctime++;
            for(int i=0; i<n; i++){
                Pair p = q.remove();
                int row = p.row;
                int col = p.col;
                for(int j=0; j<4; j++){
                    int nrow = row+drow[j];
                    int ncol = col + dcol[j];
                    if(nrow>=0 && ncol >=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==false && grid[nrow][ncol]==1){
                        q.add(new Pair(nrow,ncol));
                        visited[nrow][ncol]=true;
                        f++;
                    }
                }
            }
            
        }
        
        if(f<fresh){
            return -1;
        }
        return ctime-1;
        
        
    }
}
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}