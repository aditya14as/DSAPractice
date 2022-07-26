class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
       return Math.min(helper(cost,0,dp),helper(cost,1,dp));
    }
    public int helper(int[] cost, int i, int[] dp){
        if(i>=cost.length){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        int f = helper(cost,i+1,dp);
        int s = helper(cost,i+2,dp);
        return dp[i] = Math.min(f,s)+cost[i];
    }
}