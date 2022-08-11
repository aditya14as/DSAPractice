class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i=prices.length-1; i>=0; i--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                for(int cap=1; cap<=2; cap++){
                    if(canBuy==1){
                         dp[i][canBuy][cap]=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][canBuy][cap]);
                    }else{
                         dp[i][canBuy][cap]=Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][canBuy][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    // public int helper(int[] prices, int i, int canBuy,int cap, Integer[][][] dp){
    //     if(i==prices.length || cap==0){
    //         return 0;
    //     }
    //     if(dp[i][canBuy][cap] !=null){
    //         return dp[i][canBuy][cap];
    //     }
    //     if(canBuy==1){
    //         return dp[i][canBuy][cap]=Math.max(-prices[i]+helper(prices,i+1,0,cap,dp),helper(prices,i+1,canBuy,cap,dp));
    //     }else{
    //         return dp[i][canBuy][cap]=Math.max(prices[i]+helper(prices,i+1,1,cap-1,dp),helper(prices,i+1,canBuy,cap,dp));
    //     }
    // }
}