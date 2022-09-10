class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length+1][k+1][2];
        return helper(prices,k,0,1,dp);
    }
    public int helper(int[] prices,int k, int i, int canBuy, Integer[][][] dp){
        if(i==prices.length || k==0){
            return 0;
        }
        if(dp[i][k][canBuy]!=null){
            return dp[i][k][canBuy];
        }
        if(canBuy == 1){
            return dp[i][k][canBuy]=Math.max(-prices[i] + helper(prices,k,i+1,0,dp),helper(prices,k,i+1,canBuy,dp));
        }
        return dp[i][k][canBuy]=Math.max(prices[i]+helper(prices,k-1,i+1,1,dp),helper(prices,k,i+1,canBuy,dp));
    }
}