class Solution {
    public int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(prices,fee,1,0,dp);
    }
    public int helper(int[] prices,int fee,int canBuy, int i,Integer[][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][canBuy]!=null){
            return dp[i][canBuy];
        }
        if(canBuy==1){
            return dp[i][canBuy]=Math.max(-prices[i]+helper(prices,fee,0,i+1,dp),helper(prices,fee,canBuy,i+1,dp));
        }
        return dp[i][canBuy] = Math.max(prices[i]-fee+helper(prices,fee,1,i+1,dp),helper(prices,fee,canBuy,i+1,dp));
    }
}