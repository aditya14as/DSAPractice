class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        int[] drow = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dcol = { 1, 1, 0, -1, -1, -1, 0, 1 };
        while (pq.size() > 0) {
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            vis[row][col] = true;
            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                int ndis = dis + 1;
                if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && vis[nrow][ncol] == false && grid[nrow][ncol] == 0) {
                    pq.add(new Pair(nrow, ncol, ndis));
                    vis[nrow][ncol]=true;
                }
            }
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return dis + 1;
            }
        }
        return -1;
    }
}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int dis;

    Pair(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }

    public int compareTo(Pair o) {
        return this.dis - o.dis;
    }
}
