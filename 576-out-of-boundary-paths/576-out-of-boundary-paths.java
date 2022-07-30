class Solution {
    public int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] dp = new Long[m+1][n+1][maxMove+1];
        return (int)helper(m,n,maxMove,startRow,startColumn,dp);
    }
    public long helper(int m,int n, int maxMove, int i, int j,Long[][][] dp){
        if(i==-1 || j==-1 || i==m || j==n){
            return 1;
        }
        if(maxMove <= 0){
            return 0;
        }
        if(dp[i][j][maxMove] != null){
            return dp[i][j][maxMove]%mod;
        }
        long up = helper(m,n,maxMove-1,i-1,j,dp)%mod;
        long right = helper(m,n,maxMove-1,i,j+1,dp)%mod;
        long down = helper(m,n,maxMove-1,i+1,j,dp)%mod;
        long left = helper(m,n,maxMove-1,i,j-1,dp)%mod;
        long result = (up+right+down+left)%mod;
        return dp[i][j][maxMove]=result%mod;
    }
}