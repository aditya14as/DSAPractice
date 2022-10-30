class Solution {
    // Problem of Shortest Path Algorithm
    public int shortestPath(int[][] grid, int k) {
        if (grid[0][0] == 1) {
            k = k - 1;
        }
        Integer[][] vis = new Integer[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0, 0)); // Storing row, col, dis, and obstacles
        int[] drow = { 0, 1, 0, -1 };
        int[] dcol = { 1, 0, -1, 0 };

        while (pq.size() > 0) {
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            int obs = p.obs;
            vis[row][col] = obs; // here in vis array we are storing the obstacles
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return dis;
            }
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                int ndis = dis + 1;
                if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length) {
                    int nobs = obs + grid[nrow][ncol];
                    int lobs = k-nobs;
                    // Here if left obstacles is >= 0 and also if that grid is visited with greater no of obstacles than the current obstacles
                    // then we will visit again 
                    if(lobs>=0 && (vis[nrow][ncol]==null || vis[nrow][ncol]>nobs)){
                        vis[nrow][ncol] = nobs; // storing new obstacles in vis array
                        pq.add(new Pair(nrow,ncol,ndis,nobs));
                    }
                }
            }
        }
        return -1;
    }
}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int dis;
    int obs;

    Pair(int row, int col, int dis, int obs) {
        this.row = row;
        this.col = col;
        this.dis = dis;
        this.obs = obs;
    }

    public int compareTo(Pair o) {
        if (this.dis == o.dis) {
            return this.obs - o.obs;
        } else {
            return this.dis - o.dis;
        }
    }
}
