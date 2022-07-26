class Solution {
    public int calculateMinimumHP(int[][] grid) {
         int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
       return helper(grid,0,0,dp);
    }
    public int helper(int[][] grid,int i,int j,int[][] dp){
        int n = grid.length;
        int m= grid[0].length;
        if(i>=n || j>=m){
            return Integer.MAX_VALUE;
        }
        if(i==n-1 && j==m-1){
            int t = grid[i][j];
            return t>=0 ? 1 : -grid[i][j]+1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int f = helper(grid,i+1,j,dp);
        int s = helper(grid,i,j+1,dp);
        int temp = Math.min(f,s) - grid[i][j];
        if(temp<=0){
            return dp[i][j] = 1;
        }else{
            return dp[i][j] = temp;
        }
    }
}