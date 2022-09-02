class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int rotten = 0;
        int fresh = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                    rotten++;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        if (q.size() == 0) {
            return -1;
        }
        int ctime = 0;
        int f = 0;
        int[] drow = { 0, 1, 0, -1 };
        int[] dcol = { 1, 0, -1, 0 };
        while (q.size() > 0) {
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            ctime = Math.max(time, ctime);
            for (int j = 0; j < 4; j++) {
                int nrow = row + drow[j];
                int ncol = col + dcol[j];
                if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && visited[nrow][ncol] == false && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, time + 1));
                    visited[nrow][ncol]=true;
                    f++;
                }
            }
        }

        if (f < fresh) {
            return -1;
        }
        return ctime;
    }
}

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
