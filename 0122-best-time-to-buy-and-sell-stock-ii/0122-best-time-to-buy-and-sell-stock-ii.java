class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][2];
        return helper(prices,0,1);
    }
    public int helper(int[] prices, int i, int canBuy){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][canBuy]!=null) return dp[i][canBuy];
        if(canBuy==1){
            return dp[i][canBuy] = Math.max(-prices[i]+helper(prices,i+1,0), helper(prices,i+1,1));
        }
        return dp[i][canBuy] = Math.max(+prices[i]+helper(prices,i+1,1),helper(prices,i+1,0));
    }
}