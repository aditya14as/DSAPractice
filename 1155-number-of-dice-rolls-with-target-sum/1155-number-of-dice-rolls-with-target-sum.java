class Solution {
    public int mod= 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return helper(n,k,0,target,dp);
    }
    public int helper(int n, int k, int sum, int target, Integer[][] dp){
        if(n==0 && sum==target){
            return 1;
        }
        if(n==0 || sum>target){
            return 0;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        int ans=0;
        for(int i=1; i<=k; i++){
            ans = (ans+helper(n-1,k,sum+i,target,dp))%mod;
        }
        return dp[n][sum]=ans;
    }
}