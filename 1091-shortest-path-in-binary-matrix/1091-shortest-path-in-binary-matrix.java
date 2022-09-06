class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        if(grid[0][0]==1){
            return -1;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0,0));
        int[] drow = {0,1,1,1,0,-1,-1,-1};
        int[] dcol = {1,1,0,-1,-1,-1,0,1};
        while(q.size()>0){
            Pair p = q.remove();
            vis[p.row][p.col]=true;
            for(int i=0; i<8; i++){
                int nr = p.row+drow[i];
                int nc = p.col+dcol[i];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && vis[nr][nc]==false && grid[nr][nc]==0){
                    q.add(new Pair(nr,nc,p.dis+1));
                    vis[nr][nc]=true;
                }
            }
            if(p.row == grid.length-1 && p.col==grid[0].length-1){
                return p.dis+1;
            }
            
        }
        return -1;
    }
}
class Pair implements Comparable<Pair>{
    int row;
    int col;
    int dis;
    Pair(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
    public int compareTo(Pair o){
        return this.dis-o.dis;
    }
}