class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] dp = new Double[n+1][n+1][k+1];
        return helper(n,k,row,column,dp)/Math.pow(8,k);
    }
    public double helper(int n, int k, int i, int j, Double[][][] dp){
        if(i<0 || j<0 || i>=n || j>=n){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }
        double one = helper(n,k-1,i-2,j-1,dp);
        double two = helper(n,k-1,i-2,j+1,dp);
        double three = helper(n,k-1,i-1,j+2,dp);
        double four = helper(n,k-1,i+1,j+2,dp);
        double five = helper(n,k-1,i+2,j+1,dp);
        double six = helper(n,k-1,i+2,j-1,dp);
        double seven = helper(n,k-1,i+1,j-2,dp);
        double eight = helper(n,k-1,i-1,j-2,dp);
        
        return dp[i][j][k]=one+two+three+four+five +six+seven+eight;
    }
}