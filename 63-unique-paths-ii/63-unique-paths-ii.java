class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacleGrid,0,0,dp);
    }
    public int helper(int[][] grid,int i, int j,int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1 && grid[i][j]!=1){
            return 1;
        }
        if(i>=grid.length || j>=grid[0].length || grid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        int l = helper(grid,i+1,j,dp);
        int r = helper(grid,i,j+1,dp);
        return dp[i][j]=l+r;
    }
}