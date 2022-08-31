class Solution {
    private static final int MOD = 1000;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> sharedPeaks = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) {
            return sharedPeaks;
        }
        int cols = matrix[0].length;
        
        Set<Integer> pacific = visit(matrix, 0, 0);
        Set<Integer> atlantic = visit(matrix, rows - 1, cols - 1);
        
        for (Integer p : pacific) {
            if (atlantic.contains(p)) {
                sharedPeaks.add(List.of(decodeRow(p), decodeCol(p)));
            }
        }
        
        return sharedPeaks;
    }
    
    private Set<Integer> visit(int[][] matrix, int row, int col) {
        Set<Integer> visited = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            dfs(matrix, r, col, visited, -1);
        }
        for (int c = 0; c < matrix[row].length; c++) {
            dfs(matrix, row, c, visited, -1);
        }
        return visited;
    }
    
    private void dfs(int[][] matrix, int row, int col, Set<Integer> visited, int parentHeight) {
        if (row < 0 || col < 0
            || row == matrix.length || col == matrix[row].length
            || matrix[row][col] < parentHeight
            || visited.contains(encode(row, col))) {
            return;
        }
        
        visited.add(encode(row, col));
        int height = matrix[row][col];
        dfs(matrix, row - 1, col, visited, height);
        dfs(matrix, row + 1, col, visited, height);
        dfs(matrix, row, col - 1, visited, height);
        dfs(matrix, row, col + 1, visited, height);
    }
            
    private int encode(int row, int col) {
        return row * MOD + col;
    }
    
    private int decodeRow(int v) {
        return v / MOD;
    }
        
    private int decodeCol(int v) {
        return v % MOD;
    }
}