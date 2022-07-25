class Solution {
   
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
       return helper(grid,0,0,dp);
        
    }
    public int helper(int[][] grid, int i, int j,int[][] dp){
        if(i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if (i == grid.length- 1 && j == grid[0].length - 1) return grid[i][j];
        if(dp[i][j] !=-1) return dp[i][j];
        int l = helper(grid,i+1,j,dp);
        int r = helper(grid,i,j+1,dp);
        return dp[i][j] = grid[i][j]+Math.min(l,r);
    }
}