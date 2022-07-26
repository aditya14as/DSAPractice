class Solution {
    public int numSquares(int n) {
        int j = (int)Math.floor(Math.sqrt(n));
        int[][] dp = new int[j][n+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int[] arr = new int[j];
        for(int i=1; i<=j;i++){
            arr[i-1] = i*i;
        }
        int ans = helper(arr,j-1,n,dp);
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