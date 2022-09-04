class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] ans = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                    ans[i][j]=0;
                }
            }
        }
        
        while(q.size()>0){
            int n = q.size();
            for(int i=0; i<n; i++){
                Pair p = q.remove();
                int[] drow = {0,1,0,-1};
                int[] dcol = {1,0,-1,0};
                int row = p.r;
                int col = p.c;
                int dis = p.d;
                ans[row][col]=dis;
                for(int k=0; k<4; k++){
                    int nrow = row + drow[k];
                    int ncol = col + dcol[k];
                    if(isValid(nrow,ncol,mat) && visited[nrow][ncol]==false){
                        q.add(new Pair(nrow,ncol,dis+1));
                        visited[nrow][ncol]=true;
                    }
                }
            }
        }
        return ans;
        
    }
    public boolean isValid(int row, int col, int[][] mat){
        if(row<0 || col<0 || row>=mat.length || col>= mat[0].length){
            return false;
        }
        return true;
    }
}
class Pair{
    int r;
    int c;
    int d;
    Pair(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d= d;
    }
}