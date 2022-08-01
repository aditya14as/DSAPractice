class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==m-1 || j==n-1){
                    dp[i][j]=1;
                }
            }
        }
        for(int i=m-2; i>=0;i--){
            for(int j=n-2; j>=0; j--){
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    
}