class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(coins);
       int ans = helper(coins,coins.length-1,amount,dp);
        return ans== Integer.MAX_VALUE-1 ? -1: ans;
    }
    public int helper(int[] coins,int i,int amount,int[][] dp){
        if(amount==0){
            return 0;
        }
        if(i<0 || amount<0){
            return Integer.MAX_VALUE-1;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        if(coins[i]>amount){
            return dp[i][amount] = helper(coins,i-1,amount,dp);
        }else{
            return dp[i][amount] =  Math.min(1+helper(coins,i,amount-coins[i],dp),helper(coins,i-1,amount,dp));
        }
        
    }
}