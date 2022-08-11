class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length+1][2][k+1];
        return helper(prices,0,1,k,dp);
    }
    public int helper(int[] prices, int i, int canBuy,int cap, Integer[][][] dp){
        if(i==prices.length || cap==0){
            return 0;
        }
        if(dp[i][canBuy][cap] !=null){
            return dp[i][canBuy][cap];
        }
        if(canBuy==1){
            return dp[i][canBuy][cap]=Math.max(-prices[i]+helper(prices,i+1,0,cap,dp),helper(prices,i+1,canBuy,cap,dp));
        }else{
            return dp[i][canBuy][cap]=Math.max(prices[i]+helper(prices,i+1,1,cap-1,dp),helper(prices,i+1,canBuy,cap,dp));
        }
    }
}