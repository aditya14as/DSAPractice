class Solution {

    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        q.add(new Pair(0, 0, 0));
        int[] drow = { 0, 1, -1, 0 };
        int[] dcol = { 1, 0, 0, -1 };
        while (q.size() > 0) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = p.row + drow[i];
                int nc = p.col + dcol[i];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length ) {
                    int diff = Math.max(p.dis, Math.abs(grid[p.row][p.col] - grid[nr][nc]));
                    if (ans[nr][nc] > diff) {
                        ans[nr][nc]=diff;
                        q.add(new Pair(nr, nc, diff)); 
                    }
                }
            }
            if (p.row == grid.length - 1 && p.col == grid[0].length - 1) {
                return p.dis;
            }
        }
        return 0;
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
