class Solution {
    public int mod = 1000000007;
    public int knightDialer(int n) {
       Long[][][] dp = new Long[4][3][n+1];
        long ans=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                ans = ans + helper(n,n-1,i,j,dp)%mod;
            }
        }
        return (int)(ans%mod);
    }
    public long helper(int n, int k, int i, int j, Long[][][] dp){
        if(i<0 || j<0 || i>=4 || j>=3 || (i==3 && j==0) || (i==3 && j==2)){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[i][j][k] != null){
            return dp[i][j][k]%mod;
        }
        long one = helper(n,k-1,i-2,j-1,dp)%mod;
        long two = helper(n,k-1,i-2,j+1,dp)%mod;
        long three = helper(n,k-1,i-1,j+2,dp)%mod;
        long four = helper(n,k-1,i+1,j+2,dp)%mod;
        long five = helper(n,k-1,i+2,j+1,dp)%mod;
        long six = helper(n,k-1,i+2,j-1,dp)%mod;
        long seven = helper(n,k-1,i+1,j-2,dp)%mod;
        long eight = helper(n,k-1,i-1,j-2,dp)%mod;
        
        return dp[i][j][k]=(one+two+three+four+five +six+seven+eight)%mod;
    }
}