class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        
        for(int i=prices.length-1; i>=0; i--){
            dp[i][1]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
            dp[i][0]= Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
        }
        return dp[0][1];
        
        // return helper(prices,fee,1,0,dp);
    }
    // public int helper(int[] prices,int fee,int canBuy, int i,Integer[][] dp){
    //     if(i==prices.length){
    //         return 0;
    //     }
    //     if(dp[i][canBuy]!=null){
    //         return dp[i][canBuy];
    //     }
    //     if(canBuy==1){
    //         return dp[i][canBuy]=Math.max(-prices[i]+helper(prices,fee,0,i+1,dp),helper(prices,fee,canBuy,i+1,dp));
    //     }
    //     return dp[i][canBuy] = Math.max(prices[i]-fee+helper(prices,fee,1,i+1,dp),helper(prices,fee,canBuy,i+1,dp));
    // }
}