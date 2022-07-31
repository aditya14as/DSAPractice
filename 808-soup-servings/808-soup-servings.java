class Solution {
    public double soupServings(int n) {
        if(n>=5000) return 1.0;
        Double[][] dp = new Double[n+1][n+1];
        return helper(n,n,dp);
    }
    public double helper(int a, int b, Double[][] dp){
        if(a<=0 && b<=0){
            return 0.5;
        }
        if(a>0 && b<=0){
            return 0;
        }
        if(a<=0 && b>0){
            return 1.0;
        }
        if(dp[a][b]!=null){
            return dp[a][b];
        }
        return dp[a][b]=0.25*(helper(a-100,b,dp)+helper(a-75,b-25,dp)+helper(a-50,b-50,dp)+helper(a-25,b-75,dp));
    }
}