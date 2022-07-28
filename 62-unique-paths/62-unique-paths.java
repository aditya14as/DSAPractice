class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m,n,0,0,dp);
    }
    public int helper(int m, int n,int i, int j,int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int l = helper(m,n,i,j+1,dp);
        int r = helper(m,n,i+1,j,dp);
        return dp[i][j]=l+r;
    }
}