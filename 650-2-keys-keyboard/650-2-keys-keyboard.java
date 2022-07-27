class Solution {
    public int minSteps(int n) {
         int[][] dp = new int[n][n];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n,0,1,dp);
    }
    public int helper(int n, int prev,int curr,int[][] dp){
        if(n==curr){
            return 0;
        }
        if(n<curr){
            return 2147483000;
        }
        if(dp[curr][prev] != -1){
            return dp[curr][prev];
        }
        if(prev==0){
            //Initially we have to copy only
             return dp[curr][prev]=1+helper(n,curr,curr,dp);
        }
        if(prev==curr){
            //Here copy will only increase the operations so only pasting
           return dp[curr][prev]= 1+helper(n,prev,prev+curr,dp);
        }
        int c = helper(n,curr,curr,dp);
        int p = helper(n,prev,prev+curr,dp);
        return dp[curr][prev]= 1+Math.min(c,p);
    }
}